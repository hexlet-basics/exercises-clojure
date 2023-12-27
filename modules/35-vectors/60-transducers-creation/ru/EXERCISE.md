Для закрепления, создайте три трансдьюсера, `student-names` - который извлекает из вектора первый элемент, представляющей собой имя/фамилию студента, `lower-case-name` - который переводит имена/фамилии студентов в нижний регистр, `slugify-names` - который меняет разделитель имени/фамилии студента с пробела на `-`. А затем скомбинируйте эти трансдьюсеры в один `do-name-magic`.

Пример:

```clojure
(def students
  [["Luke Skywalker" "Jedi"]
   ["Hermione Granger" "Magic"]
   ["Walter White" "Chemistry"]])

(into [] do-name-magic students)
["luke-skywalker" "hermione-granger" "walter-white"]
```
