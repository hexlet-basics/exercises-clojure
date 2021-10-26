(ns evaluation-order-test)

(load-file "../../../src/test-helper.clj")

(assert-output "./index.clj" "46\n")
