(ns bool-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [leap-year?]]))

(assert-solution
 [2012 1913 1804 2100]
 [true false true false]
 leap-year?)
