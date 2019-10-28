(ns bg-visualize.parser
  (:require
   [bg-visualize.http :as http]
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn])
  (:gen-class))


(comment
  (in-ns 'bg-visualize.parser)
  (def p clojure.pprint/pprint)
  (require '[bg-visualize.http :as http] :reload)
  (def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")
  (def home-html (http/request home-page))
  (def list-of-laguages (lang-pages home-html))
  (def benchmarks-page-html (http/request (last (first list-of-laguages))))
  (def valid-blocks
    (let [blocks (grab result-page-html [:article :section :table :tbody])]
      (pop (vec (filter map? blocks)))))

  (def valid-block (first valid-blocks))
  ; (def algo-block (first valid-block))
  ; (def results-block (nth valid-block 2))
  ; (def result-vals (list "1.75" "4580" "1130" "1.78"))
  ())


(defn grab [content query]
  (html/select content query))


(defn clear-string [input]
  (if (string? input)
    (-> (clojure.string/trim input)
        (string/replace "," "")
        (string/replace "&nbsp;" " "))
    input))
  

(defn read-num [item]
  (if (string? item)
    (edn/read-string item)
    item))


(defn clear-cpu-load [item]
  (try
    (let [items (clojure.string/split item #"%")
          digits (map #(re-find #"\d+|\d+" %)  items)]
      (map read-num digits))
    (catch Exception _
      [])))


(defn create-map [keys vals]
  (apply merge (map hash-map keys vals)))


(defn get-content [html]
  (first (:content html)))


(defn create-href [nav]
  (let [ancher-tag (get-content nav)
        href (:href (:attrs ancher-tag))
        language-name (get-content (get-content ancher-tag))
        index (if (empty? language-name)
                :unknown
                (keyword (string/lower-case language-name)))]
    {index href}))


(defn lang-pages [home-resp]
  (let [navigation (grab home-resp [:article :section :nav :ul :li])
        list-of-hrefs (map create-href navigation)
        list-of-hrefs (apply merge list-of-hrefs)]
    (dissoc list-of-hrefs :unknown)))


(defn algorithm-name [block]
  (let [tr (grab block [:tr html/first-child (html/nth-of-type 1)])
        name (get-content (get-content (first tr)))]
    (if (string? name)
      (keyword name))))


(defn algorithm-result-values [block]
  (let [content (nth (:content block) 3)
        content (rest (rest (:content content)))
        values (map :content content)
        result (flatten (take 4 values))
        result (mapv #(-> % clear-string read-num) result)]
    (if (> (count result) 3)
      (create-map [:secs :mem :gz :busy] result)
      {})))


; (if (> (count result) 3)
;   (let [cpu-load (clear-cpu-load (last values))]
;     (conj result cpu-load))
;   [])))


(defn benchmark-result [result-row]
  (let [algo (algorithm-name result-row)        
        results (algorithm-result-values result-row)]
    {algo results}))


(comment
  (def lua (http/request "https://benchmarksgame-team.pages.debian.net/benchmarksgame/fastest/swift.html"))
  (def julia (http/request "https://benchmarksgame-team.pages.debian.net/benchmarksgame/fastest/julia.html"))
  (def lua (http/request "https://benchmarksgame-team.pages.debian.net/benchmarksgame/fastest/lua.html"))
  ())


(defn benchmark-results [benchmarks-page-html]
  (let [result-rows (grab benchmarks-page-html [:article :table :tbody])
        blocks (filter map? result-rows)]
    (if (empty? blocks)
      nil
      (map benchmark-result (pop (vec blocks))))))