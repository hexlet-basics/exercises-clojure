Обычного `if` без `else` в Clojure нет, но есть две специальные формы: `when` и `when-not`, предназначенные для этой цели.
### When
> (when test-expr body ...+)
Если результат `test-expr` истина, то вычисляется тело.

```clojure
(when (pos? -5)
  (println "hi"))
(when (pos? 5)
  (println "hi")
  (println " there"))
```

### When-not
> Тоже самое что и (when (not test-expr) body ...+).
`when-not` работает наоборот. Тело вычисляется в том случае, если `test-expr` – ложь. `when-not` хоть и бывает удобен, но резко становится нечитаемым, когда в `test-expr` появляются составные условия.

```clojure
(when-not (pos? 5)
  (println "hi"))
(when-not (pos? -5)
  (println "hi")
  (println " there"))
```
