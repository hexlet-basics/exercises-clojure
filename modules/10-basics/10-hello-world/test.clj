(ns hello-world-test
  (:require [clojure.test :refer [deftest run-tests is successful?]]))

(deftest solution-test
  (let [out (with-out-str (load-file "./index.clj"))]
    (is (= out "Hello, World!\n"))))

(defn check []
  (when-not (successful? (run-tests)) (System/exit 1)))

(check)

