### Coffee

A bit of fun with FluentBuilders to make a drink from a Coffee shop, whether it be a posh Latte with 
syrup thats extra hot, skinny and also size Large or just a basic tap water. 

#### Typical examples:

Simple Coffee example:
```java
Latte latte = coffee(LATTE)
        .withOption(syrup(HAZLENUT))
        .withOption(skinny())
        .size(STANDARD);
```
Simple Water example:
```java
Water water = water().tap();
```