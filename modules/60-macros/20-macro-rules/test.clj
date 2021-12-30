(ns macro-rules-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [triplet-macro]]))

(assert-solution
 [[[1 2 3]] [[-1 -2 -3]] [[1.2 0 2/3]] [["a" "b" ["c"]]]]
 [(list 1 2 3) (list -1 -2 -3) (list 1.2 0 2/3) (list "a" "b" ["c"])]
 (fn [[a b c]] (triplet-macro a b c)))
