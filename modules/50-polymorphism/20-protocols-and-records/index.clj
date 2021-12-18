(ns index)
;BEGIN
(defprotocol SaysSomething
  (say-something [_] "Hey, I can talk!"))

(defrecord Human []
  SaysSomething
  (say-something [_] (println "Hello, World!")))

(defrecord Cat []
  SaysSomething
  (say-something [_] (println "Meow, World!")))

(defrecord Dog []
  SaysSomething
  (say-something [_] (println "Bark, World!")))

(def human (Human.))
(def kitten (Cat.))
(def dog (Dog.))

(say-something human)
(say-something kitten)
(say-something dog)
;END
