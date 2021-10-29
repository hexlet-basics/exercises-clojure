(ns test-helper
  (:require [clojure.test :refer [deftest run-tests is successful?]]
            [clojure.string :as s]))

(defn- run-test []
  (when-not (successful? (run-tests 'test-helper)) (System/exit 1)))

(defn ^:export assert-output [expected]
  (deftest output-test
    (let [out (s/trim (with-out-str (load-file "index.clj")))]
      (is (= out expected))))
  (run-test))

(defn ^:export assert-solution [samples expected solution]
  (let [combined (map vector samples expected)]
    (deftest solution-test
      (doseq [[sample result] combined]
        (is (= (solution sample) result)))))
  (run-test))

(defn ^:export check-eq [val expected]
  (deftest value-assert-test
    (is (= val expected)))
  (run-test))

