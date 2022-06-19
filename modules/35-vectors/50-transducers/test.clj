(ns transducers-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [my-xf]]))

(assert-solution
 [[(range 10)] [(range 50)] [(range 90)]]
 [90 2450 8010]
 #(transduce my-xf + %))

(assert-solution
 [[(range 5)] [(range 10)]]
 [[0 2 4 6 8] [0 2 4 6 8 10 12 14 16 18]]
 #(into [] my-xf %))