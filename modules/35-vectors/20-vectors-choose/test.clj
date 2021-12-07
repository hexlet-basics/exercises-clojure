(ns vectors-choose-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [sum]]))

(assert-solution
 [[[]] [[1 2 3 4]] [[10 -20]]] [0 10 -10] sum)
