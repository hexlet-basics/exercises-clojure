(ns index)
;BEGIN
(def my-xf
  (comp
   (map #(* % 10))
   (map #(/ % 5))
   (filter even?)))
;END
