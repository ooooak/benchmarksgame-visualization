(ns benchmarksgame-visualization.core
  (:require
   [benchmarksgame-visualization.actions.disqualify-languages :as diq-lang]
   [benchmarksgame-visualization.actions.disqualify-algorithm :as diq-algo]
   [benchmarksgame-visualization.parser :as parser]
   [benchmarksgame-visualization.http :as http]
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn])
  (:gen-class))


(def p clojure.pprint/pprint)
(def result-file "results.edn")
(def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")

(comment
  (require '[benchmarksgame-visualization.actions.sum :as sum] :reload)
(require '[benchmarksgame-visualization.actions.disqualify-algorithm :as diq-algo] :reload)
  (def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")
  (def home-html (http/request home-page))
  (def list-of-laguages (parser/lang-pages home-html))

  (def benchmarks-page-html (http/request (last (first list-of-laguages))))
  (def valid-blocks (grab result-page-html [:article :section :table :tbody]))
  ())


(comment
  (def crawl-data (crawl))
  (def file-data (apply merge crawl-data))
  (spit result-file file-data)
  (def data (edn/read-string (slurp result-file)))
  ())


(defn handle-url [[lang url]]
  (let [resp (http/request url)
        values (parser/benchmark-results resp)
        values (if-not  (empty? values) (apply merge values) values)]    
    {lang values}))


(defn crawl []
  (let [home-html (http/request home-page)
        list-of-laguages (parser/lang-pages home-html)
        results (doall (pmap handle-url list-of-laguages))]
    results))


(def data (edn/read-string (slurp result-file)))


(def data-disqualified-languages
  (let [languages (diq-lang/disqualified-languages data)]
    (diq-lang/dissoc-languages data languages)))


(def data-disqualified-algorithms
  (let [missing-algorithms (diq-algo/get-missing-algorithms data)]
    (diq-algo/dissoc-algorithems data missing-algorithms)))


(def sum-disqualified-languages
  (sum/sum data-disqualified-languages))

(def sum-disqualified-algorithms
  (sum/sum data-disqualified-algorithms))



; (p (sort-by :secs sum-disqualified-languages))
; (p (sort-by :gz sum-disqualified-algorithms))
; (p (sort-by :mem added-sum))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
