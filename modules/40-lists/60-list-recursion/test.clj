(ns recur-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [skip]]))

(assert-solution
 [[-5 '(1 2 3)] [0 '(1 2 3)] [1 '(1 2 3)] [10 '(1 2 3)]]
 ['(1 2 3) '(1 2 3) '(2 3) '()]
 skip)

