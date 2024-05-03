(ns index)
;BEGIN
(defn programmer-level [points-count]
  (cond
    (< points-count 10) "junior"
    (< points-count 20) "middle"
    :else "senior"))
;END
