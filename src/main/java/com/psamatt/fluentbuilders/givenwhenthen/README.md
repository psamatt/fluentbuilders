### Given When Then

This is a take on the BDD style of given, when, then that we should all be familiar
with but utilising Java8 Consumer to action "something"

#### Typical examples:

Simple example:
```java
int number = ...;
int newNumber = given(number)
    .when(i -> i > 10000)
        .then(i -> doSomething())
    .when(i -> i > 1000)
        .then(i -> doSomethingOther())
    .orElse(doSomethingElse());
```
