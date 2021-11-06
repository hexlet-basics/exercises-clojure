(ns index)
;BEGIN
(defn partiphify [numbers parts]
  (let [part (int (Math/ceil (/ (count numbers) parts)))
        divided-vec (vec (map vec (partition-all part numbers)))
        final-vec (if (not= (count divided-vec) parts) (conj divided-vec []) divided-vec)]
    final-vec))
;END
