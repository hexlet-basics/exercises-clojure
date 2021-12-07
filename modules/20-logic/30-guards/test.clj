(ns guards-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [say-boom]]))

(assert-solution [["hey"] ["go"]] [nil "Boom!"] say-boom)
