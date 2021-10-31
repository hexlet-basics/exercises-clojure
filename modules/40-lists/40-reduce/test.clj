(ns reduce-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [max-delta]]))

(assert-solution
 [['() '()] ['(-5) '(-15)] ['(0) '(42)] ['(10 -15 35) '(2 -12 42)]]
 [0 10 42 8]
 max-delta)
