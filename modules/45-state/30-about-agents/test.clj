(ns agents-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [transit]]))

(assert-solution
 [[(agent 100) (agent 50) 20] [(agent 10) (agent 100) 10] [(agent 50) (agent 30) 50]]
 [[80 70] [0 110] [0 80]]
 transit)
