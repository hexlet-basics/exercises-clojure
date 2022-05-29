(ns index)
;BEGIN
(def forbidden-list #{(symbol "clojure") (symbol "is") (symbol "bad")})

(defmacro special-defn [name args body]
  (if-not (contains? forbidden-list name)
    (list 'defn name args body)
    "you can't define this function"))

(special-defn my-sum [a b] (+ a b))

(special-defn my-diff [a b] (- a b))
;END
