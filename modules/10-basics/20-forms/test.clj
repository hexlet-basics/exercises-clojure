(ns form-test
  (:require [clojure.test :refer [deftest run-tests is]]))

(deftest solution-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "84\n"))))

(run-tests 'form-test)
