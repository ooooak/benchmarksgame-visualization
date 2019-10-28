(ns bg-visualize.sum
  (:gen-class))


(defn- sum-by-keys [key values]
  (apply + (map key values)))


; We can make this function better
; TODO: it will blow up if we pass mssing index
(defn- sum-result [rows]
  (let [rows (vals rows)]
    {:gz (sum-by-keys :gz rows)
     :mem (sum-by-keys :mem rows)
     :secs (sum-by-keys :secs rows)
     :busy (sum-by-keys :busy rows)}))


(defn- sum* [[lang items]]
  (assoc (sum-result items) :lang lang))


(defn sum [data]
  (map sum* data))
