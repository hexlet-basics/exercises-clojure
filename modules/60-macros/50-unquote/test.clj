(ns quote-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [strange-macro]]))

(assert-solution [[0 1 2 3] [1 2 3 4] [2]] [0 0 0] (fn [& args] (strange-macro args)))
