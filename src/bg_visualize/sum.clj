(ns bg-visualize.sum
  (:gen-class))


(defrecord Benchmark [lang cpu ram code])

(defn sum-result [index data]
  (apply + (map index data)))

(defn construct [result]
  (let [lang (first result)
        data (vals (second result))
        cpu (sum-result :secs data)
        ram (sum-result :mem data)
        code (sum-result :gz data)]
    (Benchmark. lang cpu ram code)))


(defn sum [data]
  (map construct data))
