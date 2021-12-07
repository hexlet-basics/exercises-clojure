(ns filters-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [increment-numbers]]))

(assert-solution
 [['()] ['("a" "b" false)] ['(1 1/2 "foo")]]
 ['() '() '(2 3/2)]
 increment-numbers)
