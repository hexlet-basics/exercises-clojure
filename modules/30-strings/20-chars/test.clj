(ns chars-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [next-chars]]))

(assert-solution
 [["abc"] [""] ["12345"] ["12345abc"]]
 ["bcd" "" "23456" "23456bcd"]
 next-chars)
