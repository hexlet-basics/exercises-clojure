Реализуйте функцию `lookup`, которая бы должна принимать аргумент-ключ и список пар "ключ-значение" и возвращать либо пару "ключ-значение", где ключ равен первому аргументу, либо возвращать `false`, если подходящих пар в списке не нашлось. Если подходящих пар найдётся несколько, вернуть нужно *первую*.
Примеры:

```clojure
(def user-ages
  (list (list "Tom" 31)
        (list "Alice" 22)
        (list "Bob" 42)))
(lookup "Bob" user-ages) ; '("Bob" . 42)
(lookup "Tom" user-ages) ; '("Tom" . 31)
(lookup "Moe" user-ages) ; false
```
