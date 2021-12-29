(ns index)
;BEGIN
(defmacro triplet-macro [a b c]
  (list list a b c))

(println (triplet-macro 1 2 3))
(println (triplet-macro -1 -2 -3))
;END
