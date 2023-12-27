Реализуйте функцию `programmer-level`, которая принимает на вход количество баллов, и возвращает уровень разработчика на основе этого числа. Если баллов от 0 до 10, то это junior, от 10 до 20 – middle, от 20 и выше – senior.

```clojure
(programmer-level 10) ; middle
(programmer-level 0) ; junior
(programmer-level 40) ; senior
```
