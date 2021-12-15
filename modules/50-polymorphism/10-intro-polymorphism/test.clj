(ns intro-polymorphism-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [my-calc]]))

(assert-solution
 [[["+" 1 2]] [["-" 3 1]] [["*" 3 3]]] [3 2 9] my-calc)
