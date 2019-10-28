(ns bg-visualize.chartdata
  (:gen-class))


(defn guess-color [label]
  (case label
    :code "gray"
    :ram "blue"
    "red"))

(defn guess-label [index]
  (case index
    :gz :code
    :mem :ram
    :secs :cpu
    nil))

(defn chart-lib-struct [label langs data]
  {:labels langs
   :datasets [{:label  label
               :backgroundColor (guess-color label)
               :data data}]})

(defn gen-data [dataset index]
  (let [sorted (sort-by index dataset)
        data (mapv index sorted)
        langs (mapv :lang sorted)
        label (guess-label index)]
    (chart-lib-struct label langs data)))
