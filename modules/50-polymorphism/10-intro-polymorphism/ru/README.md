Как уже ранее говорилось, получить полиморфное поведение в Clojure достаточно просто:

```clojure
; Создадим простой калькулятор с помощью хеш-мапы
(defn calc [first-num second-num operation]
  (let [operations-map {"+" +
                        "-" -
                        "*" *
                        "^" (fn [a b] (int (Math/pow a b)))}]
  ((operations-map operation) first-num second-num)))

(calc 2 3 "+") ; => 5
(calc 2 3 "-") ; => -1
(calc 2 3 "*") ; => 6
(calc 2 3 "^") ; => 8
```

Однако! В Clojure есть еще несколько механизмов, для достижения такого же эффекта, с помощью `defmulti` и `defmethod`. Рассмотрим пример:

```clojure
; Определим мультиметод
(defmulti greeting
; в методе мы извлекаем из хеш-мапы значение под ключем `language`
  (fn [x] (get x "language")))

; Определим методы для мультиметода, значение,
; которое будет передано в него и будет нашим ключем диспетчеризации
(defmethod greeting "English" [_]
  "Hello!")

(defmethod greeting "Russian" [_]
  "Привет!")

; Создадим хеш-мапы для проверки наших методов
(def en {"id" "1" "language" "English"})
(def ru {"id" "2" "language" "Russian"})

(greeting en)
; => "Hello!"

(greeting ru)
; => "Привет!"
```

Как было описано выше, для регистрации методов для мультиметода нам необходимо какое-либо значение, по которому мы будем производить диспетчеризацию.

```clojure
; Попробуем вызвать метод на значении, которое еще не зарегистрировано
(def de {"id" "3" "language" "Hallo"})

(greeting de)
Execution error (IllegalArgumentException) at user/eval2502 (REPL:1).
No method in multimethod 'greeting' for dispatch value: Hallo
```

При попытке вызвать мультиметод на незарегистрированном значении возникает ошибка, однако с помощью опции `:default` можно подстраховаться и обработать такую ситуацию.

```clojure
; Создадим метод по умолчанию, если не найдено подходящего
; Важно, мы передаем в качестве значения символ :default !
(defmethod greeting :default [_]
  "Incorrect language provided!")

(greeting de)
; => "Incorrect language provided!"
```

Важно отметить, что мультиметод может ориентироваться не только на переданное значение, но и тип (то есть класс) передаваемого значения:

```clojure
; Создаем мультиметод, который производит
; диспетчеризацию по переданному типу (классу)
(defmulti hey class)

(defmethod hey Long [_] "You passed an integer!")

(defmethod hey String [x] (str "You passed a string: " x " !"))

(defmethod hey clojure.lang.PersistentVector [_]
  "You passed a vector!")

(defmethod hey :default [_] "Ooops, unknown value!")

(hey 2)
; => "You passed an integer!"

(hey "my awesome string")
; => "You passed a string: my awesome string !"

(hey [1 2])
; => "You passed a vector!"

(hey {:some "value"})
; => "Ooops, unknown value!"
```
