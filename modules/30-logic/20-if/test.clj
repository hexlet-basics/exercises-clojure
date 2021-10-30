(ns if-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [sentence-type]]))

(assert-solution
 [["HOW?"] ["HoW?"] ["clojure"] ["CLOJURE"]]
 ["cry" "common" "common" "cry"]
 sentence-type)
