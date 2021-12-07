(ns atoms-validation-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [vec-even?]]))

(assert-solution
 [[[0 2 4 6]] [[1 3 5]] [[]] [[0 2 4 5]] [[2]]]
 [true false false false true]
 vec-even?)
