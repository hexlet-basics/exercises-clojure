(ns index)
;BEGIN
(defn to-sorted-map [hash-coll]
  (into (sorted-map) hash-coll))
;END
