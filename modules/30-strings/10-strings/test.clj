(ns intro-str-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [str-reverse]]))

(assert-solution
 [["str"] [""] ["Hello"] ["some-string!"]]
 ["rts" "" "olleH" "!gnirts-emos"]
 str-reverse)
