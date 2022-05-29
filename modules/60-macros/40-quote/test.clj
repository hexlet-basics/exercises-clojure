(ns quote-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [my-sum my-diff]]))

(assert-solution [[4 2] [0 2] [2 2]] [6 2 4] my-sum)

(assert-solution [[4 2] [0 2] [2 2]] [2 -2 0] my-diff)
