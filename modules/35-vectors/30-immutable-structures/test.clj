(ns immutable-structures-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [partiphify]]))

(assert-solution
 [[[1] 2] [[1 2 3] 3] [[1 2 3 4 5] 2]]
 [[[1] []] [[1] [2] [3]] [[1 2 3] [4 5]]]
 partiphify)
