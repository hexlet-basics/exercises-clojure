Реализуйте функцию, которая разделит вектор на конкретное количество частей.

Примеры:

```clojure
(partiphify [1] 2)
; => [[1] []]
(partiphify [1 2 3] 3)
; => [[1] [2] [3]]
(partiphify [1 2 3 4 5] 2)
; => [[1 2 3] [4 5]]
```
