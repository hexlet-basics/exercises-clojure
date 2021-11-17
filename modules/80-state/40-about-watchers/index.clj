(ns index)
;BEGIN
(def my-atom (atom 0))

(add-watch my-atom :watcher
           (fn [_ _ old new]
             (print (str "Change state from " old " to " new "."))))

(swap! my-atom inc)
(swap! my-atom inc)
(swap! my-atom dec)
;END
