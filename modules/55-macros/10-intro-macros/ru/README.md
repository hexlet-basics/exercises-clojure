Lisp-подобные языки, в том числе Clojure, всегда славились своими макросами, которые позволяют расширять выразительность языка, позволяя программировать в терминах предметной области. По сути с помощью макросов мы программируем язык программирования! Этот процесс называется метапрограммированием.

Начнем, как обычно, с примеров:

```clojure
(defn identity-fn [x] x)

(defmacro identity-macro [x] x)
; Проверим, как ведут себя макросы в сравнении с обычными функциями

(identity-fn 2)    ; => 2
(identity-macro 2) ; => 2

(identity-fn (+ 1 2))    ; => 3
(identity-macro (+ 1 2)) ; => 3
```

Пока что макросы ведут себя так же, как и обычные функции, попробуем другой пример:

```clojure
(defn identity-fn [x]
  (println "identity of x")
  x)

(defmacro identity-macro [x]
  (println "identity of x")
  x)

(identity-fn 10)
; => identity of x
; => 10

(identity-macro 10)
; => identity of x
; => 10

; Пока что, все идентично, посмотрим дальше...

(identity-fn (println "Im nil"))
; => Im nil
; => identity of x
; => nil

(identity-macro (println "Im nil"))
; => identity of x
; => Im nil
; => nil

; Хм, а здесь получился другой порядок
; Макрос себя ведет примерно как такая функция
(defn identity-macro-fn []
  (println "identity of x")
  (println "Im nil"))

(identity-macro-fn)
; => identity of x
; => Im nil
; => nil

; Попробуем разобрать макрос с помощью функции macroexpand-1
(macroexpand-1 '(identity-macro (println "Im nil")))
; => identity of x
; => (println "Im nil")
; Вывод очень напоминает описание функции identity-macro-fn
```

Подведем итоги и сделаем вывод.

Шаги выполнения функции `identity-fn`:

- Аргумент `(println "Im nil")` выполняется первым, срабатывает побочный эффект вывода строки;
- Результат выполнения `(println "Im nil")` т.е. `nil` передается в `identity-fn`;
- `identity-fn` затем выполняет это `(println "identity of x")`, после чего срабатывает побочный эффект;
- В итоге возвращается значение, переданное в функцию, т.е. `nil`.

Шаги выполнения макроса `identity-macro`:

- `(println "Im nil")` НЕ выполняется и передается напрямую в тело макроса;
- Макрос возвращает тело, которое похоже на такой вызов функций:

```clojure
(do
  (println "identity of x")
  (println "Im nil"))
```

- Затем Clojure выполняет полученное тело, вызвав сначала первый `println` и напечатав `"identity of x"`;
- Дальше вызывается второй `println` и печатается текст `"Im nil"`;
- В итоге, возвращается nil.

Получилось объемно! Но это позволяет нам сформулировать первое правило макросов - Аргументы не выполняются перед тем, как были отправлены в тело макроса. Продолжим рассматривать макросы в следующем упражнении.
