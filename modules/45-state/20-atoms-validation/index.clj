(ns index)
;BEGIN
(defn vec-even? [avec]
  (and
   (not (empty? avec))
   (vector? avec)
   (= (count avec) (count (filterv even? avec)))))
;END
