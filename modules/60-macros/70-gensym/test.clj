(ns gensym-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [auto-sum]]))

(assert-solution [[2] [12] [112]] [12 22 122] (fn [arg] (do (intern 'index 'my-var 0) (auto-sum arg))))
