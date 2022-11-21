(ns transducers-creation-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [do-name-magic]]))

(assert-solution
 [[[]]
  [[["Harry Potter" "Magic"]]]
  [[["Luke Skywalker" "Jedi"]
    ["Hermione Granger" "Magic"]
    ["Walter White" "Chemistry"]]]]
 [[] ["harry-potter"] ["luke-skywalker" "hermione-granger" "walter-white"]]
 #(into [] do-name-magic %))
