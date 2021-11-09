(ns contains-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [my-contains?]]))

(assert-solution
 [[[1 2 4 9] 2] [[1 2 4 9] 0] [[1 2 4 9] 9]]
 [true false true]
 my-contains?)
