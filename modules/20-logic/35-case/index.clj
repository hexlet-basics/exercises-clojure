(ns index)
;BEGIN
(defn humanize-permission [v]
  (case v
    "x" "execute"
    "w" "write"
    "r" "read"))
;END
