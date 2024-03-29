Вспомним платформу JVM, которую использует Clojure. Часто кишки JVM рантайма выглядывают наружу, из-за чего большинство ошибок во время работы программ трудночитаемыми. Например:

```clojure
; вызываем (1)
(1)
Execution error (ClassCastException) at user/eval1 (REPL:1).
class java.lang.Long cannot be cast to class clojure.lang.IFn (java.lang.Long is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')
```

Рассмотрим распространенные ошибки, которые возникают и разберемся, что эти ошибки означают:

`X can not be cast to Y`

Допустим есть тип `X`, но функция, которую вызывают, ожидает, что аргумент будет типом `Y`. Clojure пытается привести тип `X` к типу `Y`, но падает с ошибкой.

```clojure
; вызовем число как функцию
(def x 10)
(x)
Execution error (ClassCastException) at user/eval138 (REPL:1).
class java.lang.Long cannot be cast to class clojure.lang.IFn
```

`Don't know how to create Y: from X`

Ошибка очень схожа с примером выше, ошибка при конвертации `X` типа в `Y`.

```clojure
; попробуем проитерироваться по числу, вместо коллекции
(reduce (fn [x y] (into x (+ x 1))) [1 2 3])
Execution error (IllegalArgumentException) at user/eval1$fn (REPL:1).
Don't know how to create ISeq from: java.lang.Long
```

`Wrong number of args (X) passed to: Y`

Здесь понятно из названия, передается неправильное количество аргументов в функцию:

```clojure
; функция first принимает только один аргумент
(first 1 2 3)
Execution error (ArityException) at user/eval3 (REPL:1).
Wrong number of args (3) passed to: clojure.core/first--5402
```

`X - failed: even-number-of-forms? at: [:bindings] spec: :clojure.core.specs.alpha/bindings`

Такая ошибка возникает во время компиляции Clojure кода, например форма `let`, которая использует для связи идентификатора и данных - вектор, внутри которого два элемента, сам идентификатор и данные. Clojure внутри себя использует `clojure.spec` чтобы провалидровать такие объявления, поэтому сообщение об ошибке может отличаться:

```clojure
; валидный пример
(let [a 2]
  (+ a 4)) ; => 6

; невалидный пример
(let [a b 3]
  (+ a b))
Syntax error macroexpanding clojure.core/let at (REPL:1:1).
[a b 3] - failed: even-number-of-forms? at: [:bindings] spec: :clojure.core.specs.alpha/bindings
```

Хоть и вывод ошибок может поначалу оттолкнуть, но спустя время к ним привыкаешь.
