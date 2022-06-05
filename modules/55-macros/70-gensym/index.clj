(ns index)
;BEGIN
(defmacro auto-sum [x]
  `(let [my-var# 10]
     (+ my-var# ~x)))
;END
