(ns index)
;BEGIN
(defn my-contains? [coll elem]
  (boolean (some #(= elem %) coll)))
;END
