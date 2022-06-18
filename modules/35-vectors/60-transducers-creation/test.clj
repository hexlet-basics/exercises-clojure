(ns transducers-creation-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [do-name-magic]]))

(assert-solution
 [[[]]
  [[{:student-name "Harry Potter"
     :discipline "Magic"}]]
  [[{:student-name "Luke Skywalker"
     :discipline "Jedi"}
    {:student-name "Hermione Granger"
     :discipline "Magic"}
    {:student-name "Walter White"
     :discipline "Chemistry"}]]]
 [[] ["harry-potter"] ["luke-skywalker" "hermione-granger" "walter-white"]]
 #(into [] do-name-magic %))