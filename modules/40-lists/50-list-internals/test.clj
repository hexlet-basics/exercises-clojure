(ns list-internals-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [lookup]]))

(assert-solution
 [["foo" nil]
  ["foo" (list (list "foo" "bar"))]
  ["foo" (list (list "bar" "foo"))]
  [42 (list (list 42 0)
            (list 30 0)
            (list 42 100500))]]
 [false '("foo" "bar") false '(42 0)]
 lookup)
