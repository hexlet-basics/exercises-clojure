(ns evaluation-order-test
  (:require [clojure.test :refer [deftest run-tests is]]))

(deftest solution-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "46\n"))))

(run-tests 'evaluation-order-test)
