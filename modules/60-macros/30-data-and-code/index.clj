(ns index)
;BEGIN
(defmacro postfix-notation [[left right operator]]
  (list operator left right))
;END
