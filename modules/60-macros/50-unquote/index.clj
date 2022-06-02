(ns index)
;BEGIN
(defmacro strange-macro [coll]
  `(apply - (apply + ~coll) ~coll))
;END
