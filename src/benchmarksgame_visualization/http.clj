(ns benchmarksgame-visualization.http
  (:require
   [clojure.string :as string]
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html]
   [clojure.edn :as edn])
  (:gen-class))



(defn request [url]
  (let [resp  (client/get url)
        body (:body resp)]
    (html/html-snippet body)))


(defn request-multi [urls]
  (pmap request urls))