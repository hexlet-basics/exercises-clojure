(ns index)
;BEGIN
(defn skip [n l]
  (if (or (<= n 0) (empty? l)) l
      (skip (dec n) (rest l))))
;END
