(ns benchmarksgame-visualization.actions.disqualify-languages
  (:gen-class))


(defn- has-mising-algorithm [algorithms-with-result]
  (let [has-empty-result? #(empty? (second %))
        empty-check-result (map has-empty-result? algorithms-with-result)]
    (some #{true} empty-check-result)))


(defn- disqualified-language [[lang algorithms-with-result]]
  (let [has-mising-algorithm? (has-mising-algorithm algorithms-with-result)]
    (if has-mising-algorithm?
      lang)))


(defn disqualified-languages [data]
  (let [languages (map disqualified-language data)
        languages (filter keyword? languages)]
    languages))


(defn dissoc-languages [data languages]
  (apply dissoc data languages))

