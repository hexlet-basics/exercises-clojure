Clojure is a modern dialect of Lisp that encourages functional programming. The language uses the JVM platform. Like all Lisp-like languages, it is homoiconicity (code as data). Sometimes Clojure is called a pragmatic Lisp, because in addition to the advantages of Lisp, the language combines features of the JVM, which simplifies the creation of programs (there are even features for scripting with Clojure!). For a better understanding of the philosophy of the language, it is worth reading the report Simple Made Easy by Rich Hickey, the creator of the language.

Traditionally, we will begin by writing a program called "Hello, World! This program will display text on the screen:
<pre class='hexlet-basics-output'>
  Hello, World!
</pre>

To print something on the screen, you need to call a function (a symbolic expression). In Clojure, `(println some-str)` function is used, where `some-str` is a string enclosed in double quotes.
