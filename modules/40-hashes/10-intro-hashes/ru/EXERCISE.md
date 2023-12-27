Создайте функцию `resolve`, которая извлекает из хеш-мапы доменов IP, связанный с именем домена. Если такая запись отсутствует, то верните `"DNS_PROBE_FINISHED_NXDOMAIN"`.
Примеры:

```clojure
(resolve {"rubyonrails.org" "211.116.107.5" "clojure.org" "103.95.84.1" "phoenixframework.org" "234.214.199.63" "reactjs.org" "20.199.101.214"}
  "clojure.org")
; => "103.95.84.1"
(resolve {"rhythm.ru" "201.116.147.4" "building.ru" "103.176.11.27" "hexlet.io" "234.214.199.63" "brass.ru" "201.116.147.4"}
  "hexlet.io")
; => "234.214.199.63"
(resolve {"some.com" "127.0.0.1"} "test.net")
; => "DNS_PROBE_FINISHED_NXDOMAIN"
```
