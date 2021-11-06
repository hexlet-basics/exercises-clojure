(ns intro-vectors-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [zip]]))

(assert-solution
 [[[1 2 3 4] [5 6 7 8]] [[] []] [[1 2] [3 4]]]
 [[[1 5] [2 6] [3 7] [4 8]] [] [[1 3] [2 4]]]
 zip)
