(ns index)
;BEGIN
(defn resolve [domains domain]
  (get domains domain "DNS_PROBE_FINISHED_NXDOMAIN"))
;END
