(ns intro-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [number-presenter]]))

(assert-solution
 [[63] [14] [2]]
 ["decimal 63  octal 77  hex 3f  upper-case hex 3F"
  "decimal 14  octal 16  hex e  upper-case hex E"
  "decimal 2  octal 2  hex 2  upper-case hex 2"]
 number-presenter)
