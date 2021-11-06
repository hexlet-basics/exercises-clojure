(ns index)
;BEGIN
(defn transit [first-acc second-acc amount]
  (let [first-proceeded (swap! first-acc - amount)
        second-proceeded (swap! second-acc + amount)]
    [first-proceeded second-proceeded]))
;END
