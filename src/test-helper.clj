(require '[clojure.test :refer [deftest run-tests is successful?]]
         '[clojure.string :as s])

(defn ^:export assert-output [path expected]
  (deftest solution-test
    (let [out (s/trim (with-out-str (load-file path)))]
      (is (= out expected))))
  (when-not (successful? (run-tests)) (System/exit 1)))
