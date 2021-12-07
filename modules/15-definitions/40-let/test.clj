(ns define-fun-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [prod-sum]]))

(assert-solution [[1] [2] [3] [4]] [2 6 12 20] prod-sum)
