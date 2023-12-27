Создайте функцию `to-sorted-map`, которая конвертирует обычную хеш-мапу в сортированную.

```clojure
(to-sorted-map {3 :c 2 :b 1 :a})
; => {1 :a, 2 :b, 3 :c}

(to-sorted-map {})
; => {}

(to-sorted-map {"c" 3 "b" 2 "a" 1})
; => {"a" 1, "b" 2, "c" 3}

(to-sorted-map {:c 3, :b 2, :a 1})
; => {:a 1, :b 2, :c 3}
```
