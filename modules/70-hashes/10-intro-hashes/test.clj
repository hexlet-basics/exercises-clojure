(ns intro-hashes-test
  (:require [test-helper :refer [assert-solution]]
            [index :refer [resolve]]))

(assert-solution
 [[{"rubyonrails.org" "211.116.107.5" "clojure.org" "103.95.84.1" "phoenixframework.org" "234.214.199.63" "reactjs.org" "20.199.101.214"} "clojure.org"]
  [{"rhythm.ru" "201.116.147.4" "building.ru" "103.176.11.27" "hexlet.io" "234.214.199.63" "brass.ru" "201.116.147.4"} "hexlet.io"]
  [{"some.com" "127.0.0.1"} "test.net"]]
 ["103.95.84.1" "234.214.199.63" "DNS_PROBE_FINISHED_NXDOMAIN"]
 resolve)
