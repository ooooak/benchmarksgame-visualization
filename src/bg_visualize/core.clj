(ns bg-visualize.core
  (:require
   [bg-visualize.invalid-lang :as invalid-lang]
   [bg-visualize.sum :as sum]
   [bg-visualize.parser :as parser]
   [bg-visualize.http :as http]
   [bg-visualize.chartdata :as chartdata]
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn]
   [cheshire.core :refer :all])
  (:gen-class))


(def p clojure.pprint/pprint)

(def result-file "results.edn")

(def home-page "https://benchmarksgame-team.pages.debian.net/benchmarksgame/")

(defn json [data]
  (generate-string data))

(comment
  (require '[bg-visualize.sum :as sum] :reload)
(require '[bg-visualize.disqualify-algorithm :as diq-algo] :reload)
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


; (def data-disqualified-algorithms
;   (let [missing-algorithms (diq-algo/get-missing-algorithms data)]
;     (diq-algo/dissoc-algorithems data missing-algorithms)))

; (def sum-disqualified-algorithms
;   (sum/sum data-disqualified-algorithms))


; really bad, make it easy

; :lua :chapel :pascal :lisp :typescript :smalltalk
; :swift :julia :ada :c :c++ :f# :c# :perl
; :fortran :dart
(def langs-to-skip
  (list))

(def data-sum
  (let [languages (invalid-lang/get data)
        data (invalid-lang/drop data languages)
        data (invalid-lang/drop data langs-to-skip)]
    (sum/sum data)))


(def ram (json (chartdata/gen-data data-sum :mem)))
(def code (json (chartdata/gen-data data-sum :gz)))
(def cpu (json (chartdata/gen-data data-sum :secs)))

; (p (sort-by :secs (:cpu chart-data)))
; (p (sort-by :gz sum-disqualified-algorithms))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
