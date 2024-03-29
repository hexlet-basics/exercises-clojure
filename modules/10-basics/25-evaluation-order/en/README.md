Let's try to turn the expression `5 - 3 + 1` into a Clojure program. The order in which the elements of this compound expression are calculated is strictly determined in terms of arithmetic. First, `5 - 3` is calculated, then one is added to the result.

Let's start with what is calculated first: `5 - 3` turns into `(- 5 3)`. Then we add the result to one: `(+ (- 5 3) 1)`. Since addition is a commutative operation (remember "the sum does not change by changing the places of the summands"?), the same can be written in another order: `(+ 1 (- 5 3))`. What does not change is that there is an operation at the beginning of each list.

Notice that the expressions evaluated first are at the bottom of the tree. This behavior is common to most conventional languages. Function arguments are evaluated first, then the function itself is called.

Let's try another version: `5 - (3 + 1)`. In this expression, the parentheses set a different precedence. It means that the sum of one and three will be calculated first. So we write `(+ 3 1)` (or so `(+ 1 3)`). Now let's take the five and subtract the result from it: `(- 5 (+ 1 3))`.

At such moments, another distinctive feature of Lisp languages comes to light. The tree structure of the program itself determines the sequence of subtree computation. There is no need to use additional brackets.

Another example: `5 + 7 + (8 - 3) - (8 * 5)`. We act according to the usual scheme:
* `(* 5 8)`
* `(- 8 3)`
* `(+ 5 7 (- 8 3))`
* `(- (+ 5 7 (- 8 3)) (* 5 8))`

In some situations, the order in which the list items are calculated does not match the order in which they are placed. This happens when using special forms and macros. We will talk about this later.
