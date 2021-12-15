(ns index)
;BEGIN
(defmulti my-calc (fn [[operation _ _]] operation))

(defmethod my-calc "+" [[_ first-op second-op]] (+ first-op second-op))

(defmethod my-calc "-" [[_ first-op second-op]] (- first-op second-op))

(defmethod my-calc "*" [[_ first-op second-op]] (* first-op second-op))
;END
