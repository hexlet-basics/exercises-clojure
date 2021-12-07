(ns intro-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [str-reverse]]))

(assert-solution
 [[["my" "str"]] [[]] [["hello" "world" "foo" "!"]]]
 [["ym" "rts"] [] ["olleh" "dlrow" "oof" "!"]]
 str-reverse)
