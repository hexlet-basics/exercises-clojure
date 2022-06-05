(ns closing-toughts-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [macro-inc]]))

(assert-solution [[1] [2] [3]] [2 3 4] (fn [arg] (macro-inc arg)))
