(ns case-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [humanize-permission]]))

(assert-solution [["x"] ["r"] ["w"]] ["execute" "read" "write"] humanize-permission)
