Функции `map` и `filter` обрабатывают списки, сохраняя саму структуру. Но иногда нужно избавиться от этой самой структуры, вычислив какое-то итоговое значение. Простейший пример — сумма всех чисел в списке. Или текст, собранный из списка строк.
В процедурных языках для получения итоговых значений по списку проходят с использованием цикла и промежуточный результат хранят в отдельной переменной — в так называемом *аккумуляторе*.
Декларативным же аналогом такого цикла будет операция *сворачивания* (*folding*) или, как ещё говорят, получение *свёртки* (*fold*). Суть сворачивания списка заключается в последовательном применении некоторой *бинарной операции* к очередному элементу списка и текущему значению аккумулятора у с целью получить новое значение аккумулятора. Давайте рассмотрим процесс сворачивания списка `(list 1 2 3 4)` в сумму чисел. Начальным значением аккумулятора будет `0`, а операцией — `+`. Сложить числа можно как минимум двумя способами:
1. двигаясь от первого элемента к последнему, слева-направо
  ```
  (((0 + 1) + 2) + 3) + 4
  ```
2. двигаясь от последнего элемента к первому, справа-налево
  ```
  1 + (2 + (3 + (4 + 0)))
  ```
Для операции сложения не имеет значения то, какой из вариантов мы выберем. Потому что операция сложения [ассоциативна](https://ru.wikipedia.org/wiki/%D0%90%D1%81%D1%81%D0%BE%D1%86%D0%B8%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D0%B0%D1%8F_%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F). Но далеко не все операции таковы: например, при конкатенации строк важно, последнюю мы будем с первой складывать или наоборот!
Однако из-за того, что Clojure недостаточно ленив, то в нем используется только свертка слева-направо, с помощью функции `reduce`:

```clojure
(reduce + 0 (list 1 2 3)) ; 6
(reduce - 0 (list 1 2 3)) ; -6
```

Попробуем теперь выводить каждое новое значение на экран, игнорируя аккумулятор:

```clojure
(defn f [acc x]
  (println x))
(reduce f nil '(1 2 3))
; => 1
; => 2
; => 3
```

В большинстве случаев используют левую свёртку (`reduce`) потому, что она более интуитивна — двигается от первого элемента к последнему — и работает *эффективнее*. Однако иногда полезна именно правая, но в стандартной библиотеке она отсутствует.
Стоит напоследок упомянуть, что `reduce` не может обходить несколько списков одновременно, как это делает `map`, поэтому придется предварительно подготовить обрабатываемые списки в промежуточный.