Вернемся к исправлению макроса `special-defn`. Вспомним, что мы хотим вернуть список, содержащий *символ* `defn` и *значения* `name`, `args` и `body` (подумайте о порядке "цитирования" в итоговом списке).

Затем создайте две функции через полученный макрос:

- `my-sum`, в которую передаются два числа и суммируются;
- `my-diff`, в которую передаются два числа, а затем из первого вычитается второе число.
