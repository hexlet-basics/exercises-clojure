Реализуйте функцию `max-delta`, которая должна принимать два списка чисел и вычислять максимальную разницу (абсолютное значение разницы) между соответствующими парами элементов.
Пример использования:

```clojure
(max-delta
  (list 10 -15 35)
  (list 2 -12 42)) ; 8
```
Вам пригодятся функции `Math/abs` и `max`:

```clojure
(Math/abs 42)    ; 42
(Math/abs -13)   ; 13
(max 1 5 3) ; 5
```
