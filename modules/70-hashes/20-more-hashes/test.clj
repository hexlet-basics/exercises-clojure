(ns intro-hashes-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [freq]]))

(assert-solution
 [[["a" "b" "c" "a" "a" "c" "a" "d" "b"]]
  [[]]
  [["Clojure" "Ruby" "Clojure" "Elixir" "Ruby" "HTML" "JS"]]
  [[10 10 10 20 300 41 53]]
  [[:a :b :c :d :a :a]]]
 [{"a" 4 "b" 2 "c" 2 "d" 1}
  {}
  {"Clojure" 2 "Ruby" 2 "Elixir" 1 "HTML" 1 "JS" 1}
  {10 3 20 1 300 1 41 1 53 1}
  {:a 3 :b 1 :c 1 :d 1}]
 freq)
