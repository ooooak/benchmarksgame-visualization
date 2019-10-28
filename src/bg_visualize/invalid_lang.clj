(ns bg-visualize.invalid-lang
  (:gen-class))


(def has-empty-result? #(empty? (second %)))

(defn- has-mising-algo [results]
  (let [empty-check-result (map has-empty-result? results)]
    (some #{true} empty-check-result)))


(defn- disqualified-language [[lang algorithms-with-result]]
  (let [has-mising-algorithm? (has-mising-algo algorithms-with-result)]
    (if has-mising-algorithm?
      lang)))


; get list of languages that does not valid result for all the algorithms
(defn get [data]
  (let [langs (map disqualified-language data)]
    (filter keyword? langs)))

(defn drop [data languages]
  (apply dissoc data languages))

