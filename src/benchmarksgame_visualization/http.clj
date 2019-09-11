(ns benchmarksgame-visualization.http
  (:require
   [clj-http.client :as client]
   [net.cgrand.enlive-html :as html])
  (:gen-class))


(defn request [url]
  (let [resp  (client/get url)
        body (:body resp)]
    (html/html-snippet body)))
