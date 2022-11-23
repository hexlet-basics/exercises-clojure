(ns index)
;BEGIN
(defn student-names
  ([] (map first))
  ([students] (sequence (student-names) students)))

(defn lowercase-names
  ([] (map  clojure.string/lower-case))
  ([students] (sequence (lowercase-names) students)))

(defn slugify-names
  ([] (map #(clojure.string/replace % #" " "-")))
  ([students] (sequence (slugify-names) students)))

(def do-name-magic (comp (student-names) (lowercase-names) (slugify-names)))
;END
