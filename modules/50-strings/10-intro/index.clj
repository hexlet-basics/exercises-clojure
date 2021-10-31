(ns index
  (:require [clojure.string :as s]))
;BEGIN
(defn str-reverse [strings]
  (mapv s/reverse strings))
;END
