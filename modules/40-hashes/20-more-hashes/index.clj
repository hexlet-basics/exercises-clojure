(ns index)
;BEGIN
(defn freq [col]
  (reduce (fn [acc key]
            (if (contains? acc key)
              (let [current-val (acc key)
                    actual-val (inc current-val)]
                (assoc acc key actual-val))
              (assoc acc key 1))) {} col))
;END
