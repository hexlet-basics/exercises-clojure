(ns index
  (:require [clojure.string :refer [upper-case]]))
;BEGIN
(defn sentence-type [text]
  (if (= (upper-case text) text)
    "cry"
    "common"))
;END
