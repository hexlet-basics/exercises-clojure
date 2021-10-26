(ns hello-world-test)

(load-file "../../../src/test-helper.clj")

(assert-output "./index.clj" "Hello, World!\n")
