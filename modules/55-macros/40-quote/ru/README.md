Начнем с небольшой задачи, допустим, у нас есть определенный список названий в пространстве имен, которые мы хотим оставить нетронутыми в этом пространстве. Иначе говоря, мы хотим позволить именовать (определять) функции только разрешенными именами.

Сначала проанализируем, какие данные будут переданы в наш макрос. По сути, они будут такими же, как и в форме `defn`, то есть `name`, `args` и `body`.

Классическое объявление функции это `список` - `(defn name args body)`. То есть если мы хотим определить функцию через макрос, мы должны вернуть список, как при определении функции. Единственное отличие, наш макрос `special-defn` должен проверить, находится ли `name` в запрещенном списке имен, перед тем, как объявить функцию в пространстве имен.

Теперь попробуем решить эту задачу:

```clojure
; сохраним в множество строку, которую сконвертирум в символ (потому что в defn название тоже передается символом)
(def forbidden-list #{(symbol "clojure") (symbol "is") (symbol "bad")})

(defmacro special-defn [name args body]
  (if-not (contains? forbidden-list name)
    (list defn name args body)
    "you can't define this function"))

Syntax error compiling
Can't take value of a macro: #'clojure.core/defn
```

Ошибка возникает из-за того, что Clojure пытается вычислить у символа `defn` его значение. Но так получить значение макроса нельзя, возникает ошибка. Но нам и не нужно значение `defn`. Нам нужно получить список вида: `(defn name args body)`. Познакомимся с оператором цитирования (quote).

Оператор `'` (quote operator), является первым из инструментов, о которых узнает программист, когда сталкивается с макросами. Этот оператор сообщает Clojure пропустить исполнение переданного символа. Рассмотрим пример:

```clojure
; попробуем создать функцию с неопределенным до этого символом
(defn get-foo [] foo)
Syntax error compiling at (REPL:1:1).
Unable to resolve symbol: foo in this context

; логично, мы попытались вычислить foo и получили ошибку
; теперь воспользуемся оператором '
(defn get-foo [] 'foo)

; ошибки не возникло, вызовем нашу функцию
(get-foo)
foo
```

Несмотря на то, что символ `foo` не был связан со значением, функция `get-foo` вернула этот символ (не его значение!), однако при попытке вычислить его значение, все равно возникнет ошибка.

Получается, если нужно сослаться на символ, не вычисляя его значения, нужно использовать оператор `'`.

Если расположить оператор `'` перед выражением, то этот оператор рекурсивно применится к выражению и его подвыражениям. Рассмотрим несколько примеров:

```clojure
'(foo bar baz)
(foo bar baz)

'(foo (bar tavern pub) baz)
(foo (bar tavern pub) baz)
```

Теперь попробуем применить полученные знания к нашей изначальной задаче:

```clojure
(def forbidden-list #{(symbol "clojure") (symbol "is") (symbol "bad")})

(defmacro special-defn [name args body]
  (if-not (contains? forbidden-list name)
    '(defn name args body)
    "you can't define this function"))

#'user/special-defn
; ура, наш макрос удачно скомпилировался, попробуем теперь его в деле

(special-defn clojure [a] a)
"you can't define this function"
; этот пример работает

(special-defn my-fn [a] a)
Syntax error macroexpanding clojure.core/defn
args - failed: vector? at: [:fn-tail :arity-1 :params] spec: :clojure.core.specs.alpha/param-list
args - failed: (or (nil? %) (sequential? %)) at: [:fn-tail :arity-n :bodies] spec: :clojure.core.specs.alpha/params+body

; а этот пример не работает :(
```

Мы раньше использовали `macroexpand`, как и `macroexpand-1`. Это очень полезные функции, чтобы выяснить, какой список возвращает макрос. Поэтому воспользуемся ими в очередной раз и разберемся, в чем проблема:

```clojure
(macroexpand '(special-defn my-fn [a] a))
Syntax error macroexpanding clojure.core/defn at ...
args - failed: vector? at: [:fn-tail :arity-1 :params] spec: :clojure.core.specs.alpha/param-list
args - failed: (or (nil? %) (sequential? %)) at: [:fn-tail :arity-n :bodies] spec: :clojure.core.specs.alpha/params+body
```

Не очень информативный вывод, тогда воспользуемся `macroexpand-1`:

```clojure
(macroexpand-1 '(special-defn my-fn [a] a))
(defn name args body)
```

`defn` выглядит нормально! Но что за `name`, `args` и `body`? Разве они не должны были замениться `my-fn`, `[a]` и `a`?

Список, который мы ожидали должен был быть `(defn my-fn [a] a)`, но макрос вернул символы `name`, `args`, и `body` вместо их значений.

Перед тем, как мы исправим наш макрос, проверьте себя, почему `macroexpand-1` сработал, а `macroexpand` нет? Причина в том, что `macroexpand` рекурсивно вызывает `macroexpand-1`, пока не вернется валидная Clojure форма. Так как мы возвращаем `defn`, а `defn` является макросом, то `macroexpand` пытается развернуть его и вызывает ошибку.
