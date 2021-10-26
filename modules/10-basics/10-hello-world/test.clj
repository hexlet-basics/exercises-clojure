(ns hello-world-test)

(load "test-helper")

(assert-output "index.clj" "Hello, World!")
