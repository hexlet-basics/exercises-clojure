(ns index)
;BEGIN
(defn do-today [day-of-week]
  (cond
    (and (int? day-of-week)
          (<= 1 day-of-week 7))
     (case day-of-week
       (6 7) "rest"
       "work")
    :else "???"))
;END
