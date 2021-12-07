(ns index)
;BEGIN
(defn lookup [key pairs]
  (letfn [(same-key? [kv] (= key (first kv)))]
    (let [found-pairs (filter same-key? pairs)]
      (if (empty? found-pairs)
        false
        (first found-pairs)))))
;END
