(ns index)
;BEGIN
(defn increment-numbers [xs]
  (map inc (filter number? xs)))
;END
