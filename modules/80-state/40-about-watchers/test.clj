(ns watchers-test
  (:require [test-helper :refer [assert-output]]))

(assert-output "Change state from 0 to 1.Change state from 1 to 2.Change state from 2 to 1.")
