(ns index)
;BEGIN
(defn transit [first-acc second-acc amount]
  (await (send first-acc - amount))
  (await (send second-acc + amount))
  [@first-acc @second-acc])
;END
