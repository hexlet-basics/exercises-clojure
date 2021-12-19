(ns index)
;BEGIN
(defn my-fn [_]
  (println "Hello from fn!"))

(defmacro my-macro [x]
  (println "Hello from macro!")
  x)

(my-fn (println (+ 1 2)))
(my-macro (println (+ 1 2)))
;END
