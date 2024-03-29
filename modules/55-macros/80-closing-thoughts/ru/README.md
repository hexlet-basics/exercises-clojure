Знание правил и синтаксиса макросов, еще не гарантируют правильность их написания, однако можно направить свои рассуждения в правильную сторону придерживаясь примерно такого алгоритма (впрочем, этот алгоритм подходит и под проектирование функций):

1. Подумайте о том, какие данные получает макрос
2. Задумайтесь о том, какие данные макрос должен вернуть
3. Подумайте, каким образом исходные данные трансформировать в возвращаемые

Хоть и алгоритм звучит немного очевидно(?) и иногда бывают случаи, когда пункт 2 идет впереди пункта 1, все же он позволяет направить мысли в нужное русло.

Попробуем сделать макрос `postfix` исходя из алгоритма выше:

1. Данными для макроса будут списки, например `(1 2 +)`, то есть в общем виде `(operand1 operand2 operator)`
2. Так как мы знаем, что в Lisp-подобных языках оператор идет первым, а за ним операнды, к которым оператор будет применен. То есть, в результате данные будут иметь следующую форму `(operator operand1 operand2)`
3. Посмотрим на примере, как данные будут меняться

```clojure
; входные данные => данные, которые возвращает макрос
         (1 2 +) => (+ 1 2)
```

По сути, мы возвращаем список из трех элементов:

```clojure
; входны данные => внутри макроса => данные, которые возвращает макрос
        (1 2 +) => (list + 1 2)   => (+ 1 2)
```

Так как нам нужно значение, вычисляемое макросом, то и пользоваться оператором цитирования `'` не нужно. Значит макрос будет выглядеть так:

```clojure
(defmacro postfix [[op1 op2 operator]]
  (list operator op1 op2))

(postfix (1 2 +))
3

(postfix (1 2 -))
-1
```

Благодаря тому, что Clojure предоставляет удобный REPL, создавать макросы с помощью такого алгоритма заметно проще.

Так как макросы всего лишь инструмент, то у них есть, конечно же и недостатки. Поэтому поговорим подробнее о них.

*Макросы не являются значением*

Функция может быть значением, но макрос же - нет. Это означает, что мы не можем передавать макросы в функции высшего порядка:

```clojure
(defmacro my-odd [x] `(odd? ~x))

(filter my-odd [1 2 3 4 5 6])
Syntax error compiling
Can't take value of a macro: #'user/my-odd
```

Если все же нужно передать макрос в функции высшего порядка, то придется обернуть макрос в функцию (вы это могли видеть в тестах, когда макрос, который тестируется, обернут в анонимную функцию):

```clojure
(filter #(my-odd %) [1 2 3 4 5 6])
```

Однако это может сработать далеко не во всех случаях.

*Разворачивание макроса происходит во время компиляции кода*

Это то, о чем упоминалось в третьем правиле макросов, что оно не совсем точное. Когда вы вызываете макрос в своем коде, он заменяется на список, который вызванный макрос возвращает после *компиляции* программы. А список, который вернул макрос, будет выполнен при *запуске* программы.

Звучит немного запутанно, так как при экспериментировании в REPL вы не замечаете того, как компилируется и запускается код, так как это происходит моментально. Поэтому исследуем этот вопрос чуть подробнее:

```clojure
(defmacro muliply-2 [xs]
  `(* 2 ~@xs))
```

Теперь создадим файл `example.clj` и используем там макрос `multiply-2`:

```clojure
(muliply-2 [1 3])
```

После того как мы скомпилируем файл и посмотрим на итоговый код, то увидим следующее:

```clojure
(* 2 1 3)
```

И только этот код будет выполнен при запуске *скомпилированной* программы. Так как макросу нужно знать, что находится в `xs` во время *компиляции* (из-за `~@xs`), мы не можем передать переменную в макрос:

```clojure
(defn multiply-by-2 [nums]
  (muliply-2 nums))
Syntax error (IllegalArgumentException) compiling
Don't know how to create ISeq from: clojure.lang.Symbol
```

Так как `nums` будут переданы только во время *запуска* программы, макрос не знает о том, что хранится в `nums`, однако внутри макроса мы пытаемся извлечь значения, которые хранятся в переданном *символе* (оператор `~@`). Это еще одна причина, почему нельзя передавать макросы в функции высшего порядка.

*Макросы привлекают макросы*

Сделаем еще один макрос:

```clojure
(defmacro add [& args]
  `(+ ~@args))

(add 1 2 3)
6
```

Но что будет, если мы захотим узнать сумму каждого вектора чисел в переданном списке? В обычном случае мы бы использовали простую комбинацию функций:

```clojure
(map #(apply + %) [[1 2 3] [2 4] [3 3]])
(6 6 6)
```

Но как мы помним, макросы нельзя передавать как значения:

```clojure
(defmacro add [& args]
  `(+ ~@args))

(map #(apply add %) [[1 2 3] [2 4]])
; Syntax error compiling at
; Can't take value of a macro: #'user/add
```

Придется писать еще один макрос...

```clojure
(defmacro add-vecs [vecs]
  (loop [f (first vecs)
        r (rest vecs)
        res `(list)]
    (if (seq r)
      (recur (first r) (rest r) (concat res `((add ~@f))))
      (concat res `((add ~@f))))))

(add-vecs [[1 2 3] [2 4] [3 3]])
(6 6 6)
```

Как быстро все начало запутываться... А мы ведь только начали...

*Макросы сложнее читать, писать и понимать*

Из-за того, что макросы по сути вычисляются "дважды", понимать их всегда сложнее, чем обычную функцию, а как мы знаем, понятность кода является важной частью программирования. В целом, это одна из причин, почему многие критикуют Lisp-подобные языки, так как поддерживать проект, который состоит из кучи макросов, написанных программистами, которые уже не работают в организации, задача крайне авантюрная :)

*Не нужно писать макрос, если с этим справится обычная функция*

Исключением являются случаи, когда макрос является более удобным способом организации кода, чем простая функция, прекрасным примером являются макросы `->` и `-->`:

```clojure
; это валидный код, однако он выглядит немного запутанно
(map str
  (map #(* % %)
    (map inc
      (filter even? (range 25)))))

; тот же самый код, однако операции, которые производятся над данными, понимаются намного проще и быстрее
(->> (range 25)
     (filter even?)
     (map inc)
     (map #(* % %))
     (map str))
```

В целом это все, что хотелось сказать о макросах. Для углубления понимания макросов, можно заняться чтением библиотек, используемых в Clojure, например `clojure.test`. Ну и практика, куда же без нее :)
