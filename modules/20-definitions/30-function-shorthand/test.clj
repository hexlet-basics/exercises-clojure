(ns define-fun-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [sum-of-squares]]))

(assert-solution [[2 3] [6 5]] [13 61] sum-of-squares)
