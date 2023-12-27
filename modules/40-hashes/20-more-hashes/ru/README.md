В Clojure с помощью хеш-мап коду легко задать полиморфное поведение. Хотя это и не единственный способ, но такой подход работает:

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

В языке реализованы функции по работе с вложенными словарями, например, обращение к вложенным элементам словаря. 

```clojure
; создадим вложенный хеш
(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield"
             :state "IL"}})

; обратимся к вложенному хешу
(get-in company [:address :state])
"IL"

; теперь обновим вложенный хеш
(assoc-in company [:address :street] "303 Broadway")

; => {:name "WidgetCo",
; => :address {:state "IL",
; =>           :city "Springfield",
; =>           :street "303 Broadway"}}

(def scores {"Andrew" 100 "Angela" 200})
(merge scores {"Kim" 150 "Ivan" 200})
; => {"Andrew" 100, "Angela" 200, "Kim" 150, "Ivan" 200}
```
