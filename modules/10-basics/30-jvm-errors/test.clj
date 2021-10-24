(ns jvm-errors-test
  (:require [clojure.test :refer [deftest run-tests is]]))

(deftest solution-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "256\n"))))

(run-tests 'jvm-errors-test)
