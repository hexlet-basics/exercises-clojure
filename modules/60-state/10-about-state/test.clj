(ns intro-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [transit]]))

(assert-solution
 [[(atom 100) (atom 50) 20] [(atom 10) (atom 100) 10] [(atom 50) (atom 30) 50]]
 [[80 70] [0 110] [0 80]]
 transit)
