(ns form-test)

(load-file "../../../src/test-helper.clj")

(assert-output "./index.clj" "84\n")
