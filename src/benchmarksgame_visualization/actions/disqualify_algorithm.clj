(ns benchmarksgame-visualization.actions.disqualify-algorithm
  (:require
   [benchmarksgame-visualization.parser :as parser]
   [benchmarksgame-visualization.http :as http]
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn])
  (:gen-class))

(defn- get-algorithms [algorithms-with-empty-data]
  (filter keyword? (flatten algorithms-with-empty-data)))


; get missing algorithms from all the languages
(defn- get-missing-algorithms* [[_ values]]
  (let [empty-result? #(= (second %) {})
        algorithms-and-result (filter empty-result? values)]
    algorithms-and-result))


(defn- dissoc-algorithems* [[lang m] algorithms-to-remove]
  (let [new-map (apply dissoc m algorithms-to-remove)]
    {lang new-map}))


(defn get-missing-algorithms [data]
  (let [junk (map get-missing-algorithms* data)]
    (set (get-algorithms junk))))


(defn dissoc-algorithems [data algorithms-to-remove]
  (apply merge (map #(dissoc-algorithems* % algorithms-to-remove) data)))
  