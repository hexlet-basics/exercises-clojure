(ns splicing-test
  (:require [test-helper :refer [assert-output]]
            [index :refer [strange-print]]))

(assert-output "oof\nFOO\nfoo\n!zab!\n!BAZ!\n!baz!\nERUJolc\nCLOJURE\nclojure")
