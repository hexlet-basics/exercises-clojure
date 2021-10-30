(ns bool-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [triple]]))

(assert-solution
 [["a"] [0] [true]]
 ['("a" "a" "a") '(0 0 0) '(true true true)]
 triple)
