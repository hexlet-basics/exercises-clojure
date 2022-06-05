(ns index)
;BEGIN
(defmacro strange-print [str]
  `(do
     ~@(println (clojure.string/reverse str))
     ~@(println (clojure.string/upper-case str))
     ~@(println (clojure.string/lower-case str))
     ~str))

(strange-print "foo")
(strange-print "!baz!")
(strange-print "cloJURE")
;END
