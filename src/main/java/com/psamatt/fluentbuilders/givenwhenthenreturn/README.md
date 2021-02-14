### Given When Then (Return)

This is a take on the BDD style of given, when, then that we should all be familiar
with but utilising Java8 functions to return back a value.

#### Typical examples:

Simple example:
```java
int number = ...;
int newNumber = given(number)
    .when(i -> i > 10000)
        .then(i -> i + 10)
    .when(i -> i > 1000)
        .then(i -> 1 + 5)
    .orElse(0);
```
If you need to return a different type
```java
int number = ...;
String s = given(number, returnType(String.class))
    .when(i -> i > 10000)
        .then(i -> "Very large number")
    .when(i -> i > 1000)
        .then(i -> "Very large number")
    .when(i -> i > 0)
        .then(i -> "Small number")
    .orElse("No idea");
```
```

