(ns define-fun-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [solution]]))

(assert-solution [[1] [2] [3] [4]] [1 4 9 16] solution)
