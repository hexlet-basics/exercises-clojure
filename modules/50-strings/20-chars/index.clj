(ns index
  (:require [clojure.string :as s]))
;BEGIN
(defn next-chars [string]
  (->> string
       (seq)
       (map int)
       (map inc)
       (map char)
  (s/join #"")))
;END
