(ns index)
;BEGIN
(defn max-delta [xs ys]
  (reduce (fn [acc [x y]] (max acc (Math/abs (- x y))))
          0 (map list xs ys)))
;END
