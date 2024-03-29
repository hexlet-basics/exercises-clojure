Помимо формы `def` есть еще одна форма — `defonce`. Основное ее преимущество в том, что если идентификатор уже определен, то он не переопределится и будет использоваться его прошлое значение.

```clojure
(def some-value "hello")

(defonce some-value "world")

(println some-value) ; => "hello"
```

Зачем это может быть нужно? Например, при прямом импорте каких-либо библиотек или модулей, в которых может быть заранее объявлен идентификатор. Однако если мы переопределим идентификатор с помощью `def`, тогда идентификатор будет иметь другое значение.

```clojure
(def some-value "hello")

(def some-value "world")

(println some-value) ; => "world"
```
