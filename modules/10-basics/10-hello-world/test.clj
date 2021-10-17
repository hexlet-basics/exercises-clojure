(ns hello-world-test
  (:require [clojure.test :refer [deftest run-tests is]]))

(deftest hello-world-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "Hello, World!\n"))))

(run-tests 'hello-world-test)
