Lisp-like languages are said to be languages without syntax. Of course, they have a syntax, but it is as primitive as possible, actually consisting of lists and values. In addition, Lisp languages do not have keywords and their corresponding constructs. In popular languages, there are many control constructions, such as conditions, loops, returns, variable assignments, and more. Lisp-like languages have no such constructs (this does not mean that you can't implement a loop or write a condition in Clojure!)

So how does Clojure know what it's working with now and what to do? It's all about _forms_. Any correct Lisp program is called a _form_. For example:

```clojure
;forms
(println "some-str")
(+ 1 2 3)
(- 3)
8
"hello world!"

; not forms, program will fail with error
(1 2)
Execution error (ClassCastException) at user/eval1 (REPL:1).
class java.lang.Long cannot be cast to class clojure.lang.IFn (java.lang.Long is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')
```

There are only two forms: normal and composite. The normal form corresponds to all values (and definitions, which we will get to know later) because they evaluate to themselves, e.g., the number _8_ or the string "hello". A compound form is a list that needs to be processed (evaluated) in one way or another.
