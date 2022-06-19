(ns sorted-hashes-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [to-sorted-map]]))

(assert-solution
 [[{"c" 3 "b" 2 "a" 1}]
  [{}]
  [{:c 3, :b 2, :a 1}]
  [{3 :c 2 :b 1 :a}]]
 [{"a" 1, "b" 2, "c" 3}
  {}
  {:a 1, :b 2, :c 3}
  {1 :a, 2 :b, 3 :c}]
 to-sorted-map)
