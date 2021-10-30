(ns expressions-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [do-today]]))

(assert-solution
 [[1] [2] [3] [4] [5] [6] [7] [0] [-1] [10] [false] ["oops"]]
 ["work" "work" "work" "work" "work" "rest" "rest" "???" "???" "???" "???" "???"]
 do-today)
