(ns benchmarksgame-visualization.core
  (:require
   [benchmarksgame-visualization.parser :as parser]
   [benchmarksgame-visualization.http :as http]
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn])
  (:gen-class))


(def p clojure.pprint/pprint)



; (defn results [blocks]
;   (let [valid-blocks (filter map? (:content blocks))
;         algo (parser/algorithm-name (first valid-blocks))
;         vals (parser/algorithm-result (nth valid-blocks 2))]
;     {(keyword algo) vals}))



(comment
  (require '[benchmarksgame-visualization.parser :as parser] :reload)
  ())

(comment
  (def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")
  (def home-html (http/request home-page))
  (def list-of-laguages (parser/lang-pages home-html))

  (def benchmarks-page-html (http/request (last (first list-of-laguages))))
  (def valid-blocks
    (let [blocks (grab result-page-html [:article :section :table :tbody])]
      (pop (vec (filter map? blocks)))))

  (def valid-block (first valid-blocks))
  ; (def algo-block (first valid-block))
  ; (def results-block (nth valid-block 2))
  ; (def result-vals (list "1.75" "4580" "1130" "1.78"))


  (def b)
  ())


(def result-file "results.edn")





; (map #(parser/benchmark-results (http/request (second %)) list-of-laguages))
(def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")

(defn handle-url [[lang url]]
  (let [resp (http/request url)
        values (parser/benchmark-results resp)
        values (if-not  (empty? values) (apply merge values) values)]    
    {lang values}))


; list-of-laguages  (take 2 list-of-laguages)
(defn crawl []
  (let [home-html (http/request home-page)
        list-of-laguages (parser/lang-pages home-html)
        results (doall (pmap handle-url list-of-laguages))]
    results))



(comment
  ; write to data
  (def crawl-data (crawl))
  (def file-data (apply merge crawl-data))
  (spit result-file file-data)
  (def data (edn/read-string (slurp result-file)))
  ())


(def data (edn/read-string (slurp result-file)))


; add all the results; skip keys that are missing on few. just to be fair
; first we wanna remove the keys that are in keys-to-skip
; then get values
; add values

(defn get-missing-algo-data [[_ values]]
  (filter #(empty? (val %)) values))

(def algos-to-skip
  (set (filter keyword? (flatten (map get-missing-algo-data data)))))

(defn sum-by-keys [key values]
  (apply + (map key values)))

(defn sum-result [rows]
  (let [rows (vals rows)
        ret {:gz (apply + (map :gz rows))
             :mem (sum-by-keys :mem rows)
             :secs  (sum-by-keys :secs rows)
             :busy (sum-by-keys :busy rows)}]
    ret))

(defn add-result-up [[lang items]]
  (let [items (apply dissoc items algos-to-skip)]
    (assoc (sum-result items) :lang lang)))
    

(def added-sum (map add-result-up data))

; (p (take 3 (reverse (sort-by :gz added-sum))))

; speed
; (p (sort-by :secs added-sum))

; size
; (p (sort-by :gz added-sum))
; (p (sort-by :mem added-sum))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
