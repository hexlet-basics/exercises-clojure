(ns cond-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [programmer-level]]))

(assert-solution
 [[3] [18] [40]]
 ["junior" "middle" "senior"]
 programmer-level)

