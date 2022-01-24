(ns index)
;BEGIN
(defn vec-even? [avec]
  (and
   (not (empty? avec))
   (vector? avec)
   (every? even? avec)))
;END
