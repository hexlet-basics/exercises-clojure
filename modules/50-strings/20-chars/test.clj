(ns intro-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [next-chars]]))

(assert-solution
 [["abc"] [""] ["12345"]]
 ["bcd" "" "23456"]
 next-chars)
