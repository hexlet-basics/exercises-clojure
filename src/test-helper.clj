(ns test-helper
  (:require [clojure.test :refer [deftest run-tests is successful?]]
            [clojure.string :as s]))

(defn ^:export assert-output [expected]
  (deftest solution-test
    (let [out (s/trim (with-out-str (load-file "index.clj")))]
      (is (= out expected))))
  (when-not (successful? (run-tests 'test-helper)) (System/exit 1)))

(defn ^:export assert-solution [samples expected solution]
  (let [combined (map vector samples expected)]
    (deftest solution-test
      (doseq [[sample result] combined]
        (is (= (solution sample) result)))))
  (when-not (successful? (run-tests 'test-helper)) (System/exit 1)))
