(ns data-and-code-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [postfix-notation]]))

(assert-solution
 [[[2 2 =]] [[2 2 +]] [[2 2 >]] [[2 2 /]]] [true 4 false 1]
 (fn [[op1 op2 operation]] (postfix-notation (op1 op2 operation))))
