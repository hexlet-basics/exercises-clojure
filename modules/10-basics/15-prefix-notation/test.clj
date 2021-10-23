(ns prefix-notation-test
  (:require [clojure.test :refer [deftest run-tests is]]))

(deftest solution-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "-3\n"))))

(run-tests 'prefix-notation-test)
