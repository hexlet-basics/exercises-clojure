(ns define-fun-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [square]]))

(assert-solution [[1] [2] [3] [4]] [1 4 9 16] square)
