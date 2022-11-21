(ns index
  (:require [clojure.string :as s]))
;BEGIN
(defn next-chars [string]
  (let [chars-code (map int (seq string))
        next-chars (map char (map inc chars-code))]
    (s/join #"" next-chars)))
;END
