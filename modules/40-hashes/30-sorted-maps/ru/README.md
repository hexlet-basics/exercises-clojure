Помимо стандартных хеш-мап в Clojure реализованы сортированные хеш-мапы. Семантика соответствует названию. Ключи в такой хеш-мапе будут отсортированы с помощью встроенной функции `compare`, поведение которой описано в ссылке к этому уроку.

Задается сортированная хеш-мапа с помощью функции `sorted-map`. Для изменения поведения сортировки используется функция `sorted-map-by`.

```clojure
; объявление сортированной хеш-мапы
(sorted-map :c 0 :a 28 :b 35)
{:a 28, :b 35, :c 0}

; если ключи повторяются, то будет выбран последний
(sorted-map :c 0 :a 28 :a 35 :c 2)
{:a 35, :c 2}

; важно отметить, что ключи должны быть одинакового типа, иначе функция `compare` не сможет их сравнить
(sorted-map :с 0 "a" 28, 2 35)
Execution error (ClassCastException) at java.lang.String/compareTo (String.java:134).
class clojure.lang.Keyword cannot be cast to class java.lang.String (clojure.lang.Keyword is in unnamed module of loader 'bootstrap'; java.lang.String is in module java.base of loader 'bootstrap')

; теперь создадим сортированную хеш-мапу с пользовательской функцией-компаратором
(sorted-map-by > 1 "a" 2 "b" 3 "c")
{3 "c", 2 "b", 1 "a"}
```
