Реализуйте функцию `maps`, которая должна принимать два списка — список функций и *список списков* аргументов — и возвращать список результатов применения функций к наборам аргументов. Вот как использование `maps` должно выглядеть:

```clojure
(maps
  (list
   inc
   string?)
  (list
   (list 10 20)
   (list "a" 0)))
; '((11 21) (true false))
```

Здесь
- `'(11 21)`, это результат применения `inc` к `(list 10 20)`
- `'(true false)`, это результат применения `string?` к `(list "a" 0)`