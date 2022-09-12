(ns atoms-validation-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [vec-even?]]))

(assert-solution
 [[(atom [0 2 4 6])] [(atom [1 3 5])] [(atom [])] [(atom [0 2 4 5])] [(atom [2])]]
 [true false false false true]
 vec-even?)
