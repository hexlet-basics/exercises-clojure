(ns bool-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [maps]]))

(assert-solution
 [[(list) (list)]
  [(list inc) (list (list 0))]
  [(list inc string?) (list (list 0 100) (list "foo" 42))]]
 [(list)
  (list (list 1))
  (list (list 1 101) (list true false))]
 maps)
