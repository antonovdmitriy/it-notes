# Table of contents

- [Table of contents](#table-of-contents)
- [OCP preparation](#ocp-preparation)
- [Main method trics](#main-method-trics)
- [Compile and Run](#compile-and-run)
  - [Create Jar via CLI](#create-jar-via-cli)
- [Main arguments trics](#main-arguments-trics)
- [Import packages tricks](#import-packages-tricks)
- [Initializing class](#initializing-class)
- [Numeric literals](#numeric-literals)
- [Underscores](#underscores)
- [Wrapper classes](#wrapper-classes)
- [Text blocks](#text-blocks)
- [Naming](#naming)
- [Variables declaration and initizlization](#variables-declaration-and-initizlization)
  - [Var](#var)
- [Eligibility for GC](#eligibility-for-gc)
- [Operators](#operators)
  - [Order of operator precedence](#order-of-operator-precedence)
  - [Some of unary operator](#some-of-unary-operator)
      - [Logical complement	`!a`](#logical-complementa)
    - [Bitwise complement\*\*	`~b`](#bitwise-complementb)
    - [Negation operator](#negation-operator)
    - [Increment decrement operators](#increment-decrement-operators)
    - [Modulus](#modulus)
- [Numeric promotion](#numeric-promotion)
- [Casting primitives](#casting-primitives)
- [Comparison](#comparison)
- [Ternary Operator tricks](#ternary-operator-tricks)
- [Pattern matching](#pattern-matching)
- [switch](#switch)
  - [switch statement](#switch-statement)
  - [Switch expression. Новый switch, который может возвращать значения](#switch-expression-новый-switch-который-может-возвращать-значения)
- [Cycles](#cycles)
  - [do while](#do-while)
  - [for](#for)
- [Labels](#labels)
- [Strings](#strings)
  - [String concatination](#string-concatination)
  - [important methods for OCP exam](#important-methods-for-ocp-exam)
  - [substring](#substring)
  - [equals](#equals)
  - [replace](#replace)
  - [strip and trim](#strip-and-trim)
  - [Working with indent](#working-with-indent)
  - [translateEscapes](#translateescapes)
  - [empty string](#empty-string)
  - [Formatting](#formatting)
  - [StringBuilder](#stringbuilder)
    - [Important methods](#important-methods)
    - [substring returns String](#substring-returns-string)
    - [append](#append)
    - [insert](#insert)
    - [delete](#delete)
    - [replace](#replace-1)
    - [reverse](#reverse)
  - [String pool](#string-pool)
- [Arrays](#arrays)
  - [Sort](#sort)
  - [Search](#search)
  - [Compare](#compare)
  - [Mismatch](#mismatch)
  - [Multidimensional Array](#multidimensional-array)
- [Math APIs](#math-apis)
  - [min max](#min-max)
  - [round](#round)
  - [Ceil and floor](#ceil-and-floor)
  - [Pow](#pow)
  - [random](#random)
- [Working with Dates and Times](#working-with-dates-and-times)
  - [LocalDate](#localdate)
  - [LocalTime](#localtime)
  - [LocalDateTime](#localdatetime)
  - [ZonedDateTime](#zoneddatetime)
  - [Manipulating date and times](#manipulating-date-and-times)
  - [Period](#period)
  - [Duration](#duration)
  - [Period vs Duration](#period-vs-duration)
  - [Instant](#instant)
  - [Daylight saving](#daylight-saving)
- [Data races](#data-races)


# OCP preparation

>  Some of the most time-consuming questions you may see on the exam could involve nested loops with lots of branching. Unless you spot an obvious compiler error, we recommend skipping these questions and coming back to them at the end. Remember, all questions on the exam are weighted evenly!



# Main method trics

Allowed final word in main main method and arguments
```java
public final static void main(final String[] args) {}
```

# Compile and Run

If file doesn't contain any public class it can named any. After compiling this name of file will be vanish, and we get several file with classes.

If file contain main method and package name then java after javac doesn't invoke main method if we launch it from the package directory, it can not find main method to handle this
```
javac packagea/ClassA.java packageb/ClassB.java
```
of with wildcard
```
javac packagea/*.java packageb/*.java
```

then run it with package 
```
java packageb.ClassB
```

`javac` creates by default class at the same directories. It's not goot enough. It's useful to specify a directory for classes for created package structure and put compiled files there.
```
javac -d classes packagea/ClassA.java packageb/ClassB.java
```
this command created classes folder and package structure and then compiled java classes to class files.

after that from current directory it's possible to run this programe with class path options. There are several ways to do that:
```
java -cp classes packageb.ClassB
java -classpath classes packageb.ClassB
java --class-path classes packageb.ClassB
```
On Windows, you type the following:
```
java -cp ".;C:\temp\someOtherLocation;c:\temp\myJar.jar" myPackage.MyClass
```

And on macOS/Linux, you type this:
```
java -cp ".:/tmp/someOtherLocation:/tmp/myJar.jar" myPackage.MyClass
```
The period `.`indicates that you want to include the current directory in the classpath. The rest of the command says to look for loose class files (or packages) in someOtherLocation and within myJar.jar. Windows uses semicolons `;` to separate parts of the classpath; other operating systems use colons.

Just like when you're compiling, you can use a wildcard (*) to match all the JARs in a directory. Here's an example:
```
java -cp "C:\temp\directoryWithJars\*" myPackage.MyClass
```
This command will add to the classpath all the JARs that are in directoryWithJars. It won't include any JARs in the classpath that are in a subdirectory of directoryWithJars.

## Create Jar via CLI

create jar with classes and packages from the current folder
```
jar -cvf myNewFile.jar .
jar --create --verbose --file myNewFile.jar .
```
with '-C' option to specify directory with classes
```
jar -cvf myNewFile.jar -C dir .
```

# Main arguments trics
---
use quates for arguments with spaces
```
javac Zoo.java
java Zoo "San Diego" Zoo
```
---
single file source code - compile and launch with one command and pass parameters
```
java Zoo.java Bronx Zoo
```

# Import packages tricks

The import statement doesn't bring in child packages, fields, or methods; it imports only classes directly under the package

---

When we use multiple import sql classes and date from util. We need explicitly write date class
```java
import java.util.Date;
import java.sql.*;
```
if it will be that , then it's compile error
```java
import java.util.*;
import java.sql.*;  // causes Date declaration to not compile
```

# Initializing class

> Sometimes code blocks are inside a method. These are run when the method is called. Other times, code blocks appear outside a method. These are called **instance initializers**

> Class can have name started with lower case. 

# Numeric literals

- **Octal** (digits 0–7), which uses the number `0` as a prefix—for example, `017`.
- **Hexadecimal** (digits 0–9 and letters A–F/a–f), which uses `0x` or `0X` as a prefix—for example, `0xFF`, `0xff`, `0XFf`. Hexadecimal is case insensitive, so all of these examples mean the same value.
- **Binary** (digits 0–1), which uses the number 0 followed by b or B as a prefix—for example, `0b10`, `0B10`.
# Underscores

You can add underscores anywhere except at the beginning of a literal, the end of a literal, right before a decimal point, or right after a decimal point. You can even place multiple underscore characters next to each other, although we don't recommend it.

Let's look at a few examples:

```java
double notAtStart = _1000.00;          // DOES NOT COMPILE
double notAtEnd = 1000.00_;            // DOES NOT COMPILE
double notByDecimal = 1000_.00;        // DOES NOT COMPILE
double annoyingButLegal = 1_00_0.0_0;  // Ugly, but compiles
double reallyUgly = 1__________2;      // Also compiles
```

# Wrapper classes

| Primitive type | Wrapper class | inherits Number? | Example of creating          |
| -------------- | ------------- | ---------------- | ---------------------------- |
| boolean        | Boolean       | No               | `Boolean.valueOf(true)`      |
| byte           | Byte          | Yes              | `Byte.valueOf((byte) 1)`     |
| short          | Short         | Yes              | `Short.valueOf((short) 1)`   |
| int            | Integer       | Yes              | `Integer.valueOf(1)`         |
| long           | Long          | Yes              | `Long.valueOf(1)`            |
| float          | Float         | Yes              | `Float.valueOf((float) 1.0)` |
| double         | Double        | Yes              | `Double.valueOf(1.0)`        |
| char           | Character     | No               | `Character.valueOf('c')`     |

There is also a `valueOf()` variant that converts a String into the wrapper class and `parse()`
```java
int primitive = Integer.parseInt("123");
Integer wrapper = Integer.valueOf("123");
```

All of the numeric classes in Table extend the `Number` class, which means they all come with some useful helper methods: `byteValue()`, `shortValue()`, `intValue()`, `longValue()`, `floatValue()`, and `doubleValue()`. 

```java
public abstract class Number implements java.io.Serializable {
    public Number() {super();}
    public abstract int intValue();
    public abstract long longValue();
    public abstract float floatValue();
    public abstract double doubleValue();
    public byte byteValue() {
        return (byte)intValue();
    }
    public short shortValue() {
        return (short)intValue();
    }
}
```


The `Boolean` and `Character` wrapper classes include `booleanValue()` and `charValue()`, respectively.

# Text blocks

> new line after first """ or compile error

> quates inside may be with escaping \ or not

> spaces at the end of the line are ignored but we can use \s

![Example](images/text_blocks_1.png)

![Escaping rules](images/text_blocks_2.png)

# Naming

- Identifiers must begin with a letter, a currency symbol, or a `_` symbol. Currency symbols include dollar `$`, yuan `¥`, euro `€`, and so on.
- Identifiers can include numbers but not start with them.
- A single underscore `_` is not allowed as an identifier.
- You cannot use the same name as a Java reserved word.

# Variables declaration and initizlization

initialized only `i3`
```java
void paintFence() {
   int i1, i2, i3 = 0;
}
```

Different types in one statement do not compile
```java
int num, String value; // DOES NOT COMPILE
```

```java
boolean b1, b2; // COMPILE
String s1 = "1", s2; // COMPILE
double d1, double d2; // DOES NOT COMPILE. Use one double in this case double d1, d2;
int i1; int i2; // COMPILE
int i3; i4; // DOES NOT COMPILE. Statement is finished ; and next statement without type
```

With final
```java
final int a =5, b = 4;
b = 5; // DOES NOT COMPILE

final int c =5, d;
d = 4;
d = 5; // DOES NOT COMPILE
```

```java
public void findAnswer(boolean check) {
   int answer;
   int otherAnswer;
   int onlyOneBranch;
   if (check) {
      onlyOneBranch = 1;
      answer = 1;
   } else {
      answer = 2;
   }
   System.out.println(answer);
   System.out.println(onlyOneBranch);  // DOES NOT COMPILE
}
```

```java
public void checkAnswer() {
   boolean value;
   findAnswer(value);  // DOES NOT COMPILE
}
```

> Instance and class variables (static) do not require you to initialize them. As soon as you declare these variables, they are given a default value. The compiler doesn't know what value to use and so wants the simplest value it can give the type: null for an object, zero for the numeric types, and false for a boolean. You don't need to know the default value for char, but in case you are curious, it is '\u0000' (NUL).

## Var
> local variable type inference. Let's take that apart. First comes **local** variable. This means just what it sounds like. You can only use this feature for local variables.

> The compiler looks at the code **on the line of the declaration** and uses it to infer the type

```java
public class VarKeyword {
   var tricky = "Hello"; // DOES NOT COMPILE
}
```

```java
public void reassignment() {
   var number = 7;
   number = 4;
   number = "five";  // DOES NOT COMPILE
}
```

```java
public void breakingDeclaration() {
   var silly
      = 1;
}
```

```java
 public void doesThisCompile(boolean check) {
    var question; // DOES NOT COMPILE
    question = 1;
    var answer;  // DOES NOT COMPILE
    if (check) {
       answer = 2;
    } else {
       answer = 3;
    }
    System.out.println(answer);
 }
```

It can be possible to resolve Object type while assigning null to var. But not.. designers of the language decided do not compile this.
```java
public void twoTypes() {
   int a, var b = 3;  // DOES NOT COMPILE
   var n = null;      // DOES NOT COMPILE
   var fall = 2, autumn = 2; // DOES NOT COMPILE
}
```

```java
public int addition(var a, var b) { // DOES NOT COMPILE
   return a + b;
}
```

>var is not a reserved word and allowed to be used as an identifier. It is considered a reserved type name. A reserved type name means it cannot be used to define a type, such as a class, interface, or enum

```java
package var; 
public class Var {
   public void var() {
      var var = "var";
   }
   public void Var() {
      Var var = new Var();
   }
}
```

# Eligibility for GC
```java
 public class Scope {
    public static void main(String[] args) {
       String one, two;
       one = new String("a");
       two = new String("b");
       one = two;
       String three = one;
       one = null;
    } }
```
# Operators

## Order of operator precedence


| Operator                        | Symbols and examples                             | Evaluation    |
| ------------------------------- | ------------------------------------------------ | ------------- |
| Post-unary operators            | `exprestion++`, `expression--`                   | Left-to-right |
| Pre-unary operators             | `++exprestion`, `--expression`                   | Left-to-right |
| Other unary operators           | `- ! ~ + (type)`                                 | Right-to-left |
| Cast                            | `(Type)reference`                                | Right-to-left |
| Multiplication/division/modulus | `* / %`                                          | Left-to-right |
| Addition/subtraction            | `+ -`                                            | Left-to-right |
| Shift operators                 | `<< >> >>>`                                      | Left-to-right |
| Relational operators            | `< > <= >= instanceof`                           | Left-to-right |
| Logical AND                     | `&`                                              | Left-to-right |
| Logical exclusive OR            | `^`                                              | Left-to-right |
| Logical inclusive OR            | `\|`                                             | Left-to-right |
| Conditional AND                 | `&&`                                             | Left-to-right |
| Conditional OR                  | `\|\|`                                           | Left-to-right |
| Ternary operators               | `boolean expression ? expression1 : expression2` | Right-to-left |
| Assignment operators            | `= += -= *= /= %= &= ^= \|= <<= >>= >>>=`        | Right-to-left |
| Arrow operator                  | `->`                                             | Right-to-left |

## Some of unary operator

```java
int pelican = !5;         // DOES NOT COMPILE
boolean penguin = -true;  // DOES NOT COMPILE
boolean peacock = !0;     // DOES NOT COMPILE
```

#### Logical complement	`!a`	
Inverts a boolean's logical value
```java
boolean isAnimalAsleep = false;
System.out.print(isAnimalAsleep);  // false
isAnimalAsleep = !isAnimalAsleep;
System.out.print(isAnimalAsleep);  // true
```


### Bitwise complement**	`~b`	
which flips all of the 0s and 1s in a number. It can only be applied to integer numeric types such as `byte`, `short`, `char`, `int`, and `long`. Let's try an example. For simplicity, we only show the last four bits (instead of all 32 bits).

```java
int value = 3;                   // Stored as 0011
int complement = ~value;         // Stored as 1100
System.out.println(value);       // 3
System.out.println(complement);  // -4
```

to find the bitwise complement of a number, multiply it by negative one and then subtract one.
```java
System.out.println(-1*value - 1);      // -4
System.out.println(-1*complement - 1); // 3
```

### Negation operator

```java
double zooTemperature = 1.21;
System.out.println(zooTemperature);  // 1.21
zooTemperature = -zooTemperature;
System.out.println(zooTemperature);  // -1.21
zooTemperature = -(-zooTemperature);
System.out.println(zooTemperature);  // -1.21
```

### Increment decrement operators

Pre-increment	`++w`	Increases the value by 1 and returns the **new** value

Pre-decrement	`--x`	Decreases the value by 1 and returns the **new** value

Post-increment	`y++`	Increases the value by 1 and returns the **original** value

Post-decrement	`z--`	Decreases the value by 1 and returns the **original** value

```java
int a = 2, b = 4, c = 2;
System.out.println(a ˃ 2 ? --c : b++); // 4
System.out.println(b = (a!=c ? a : b++)); // 5  first decrement but return old value. b is already 6, but then result of ternary assign to b. And this result of ternary is 5 (old value of b)
```

```java
int parkAttendance = 0;
System.out.println(parkAttendance);    // 0
System.out.println(++parkAttendance); // 1
System.out.println(parkAttendance);    // 1
System.out.println(parkAttendance--); // 1
System.out.println(parkAttendance);    // 0
```

> All of the arithmetic operators may be applied to any Java primitives, with the exception of boolean. Furthermore, only the addition operators + and += may be applied to String values, which results in String concatenation

### Modulus 

```java
System.out.println(9 / 3);  // 3
System.out.println(9 % 3);  // 0
 
System.out.println(10 / 3); // 3
System.out.println(10 % 3); // 1
 
System.out.println(11 / 3); // 3
System.out.println(11 % 3); // 2
 
System.out.println(12 / 3); // 4
System.out.println(12 % 3); // 0
```

> For a given divisor y, the modulus operation results in a value between `0` and `(y - 1)` for positive dividends, or 0, 1, 2 in this example.

> The modulus operation is not limited to positive integer values in Java; it may also be applied to negative integers and floating-point numbers. For example, if the divisor is 5, then the modulus value of a negative number is between -4 and 0. 

# Numeric promotion

1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value's data type.
3. Smaller data types, namely, byte, short, and char, are first promoted to int any time they're used with a Java binary arithmetic operator with a variable (as opposed to a value), even if neither of the operands is int.
4. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.

> For the third rule, note that unary operators are excluded from this rule. For example, applying ++ to a short value results in a short value.

```java
int x = 1;
long y = 33;
var z = x * y; // long (first rule)
```

```java
short x = 10;
short y = 3;
var z = x * y; // int (third rule)
```

```java
double x = 39.21;
float y = 2.1; // doesn't compile
var z = x + y;
```

```java
char a = 'a' + 'c'; // compile because literals
char b = 'b';
char k = a + b; // doesn't compile because of int
```

```java 
short w = 14;
float x = 13;
double y = 30;
var z = w * x / y; // double 
```

# Casting primitives

```java
int fish = 1.0;        // DOES NOT COMPILE
short bird = 1921222;  // DOES NOT COMPILE
int mammal = 9f;       // DOES NOT COMPILE
long reptile = 192_301_398_193_810_323;  // DOES NOT COMPILE
```

fix
```java
int fish = (int)1.0;
short bird = (short)1921222;  // Stored as 20678
int mammal = (int)9f;
long reptile = (long)192301398193810323;  // DOES NOT COMPILE
long reptile = 192301398193810323L
```
---
```java
short mouse = 10;
short hamster = 3;
short capybara = mouse * hamster;  // DOES NOT COMPILE
```
fix
```java
short mouse = 10;
short hamster = 3;
short capybara = (short)(mouse * hamster);
```
---
```java
short mouse = 10;
short hamster = 3;
short capybara = (short)mouse * hamster;      // DOES NOT COMPILE
short capybara = 1 + (short)(mouse * hamster);  // DOES NOT COMPILE
```

> compiler doesn't require casting when working with literal values that fit into the data type

```java
byte hat = 1;
byte gloves = 7 * 10;
short scarf = 5;
short boots = 2 + 1;
```

```java
short boots = 2 + hat;  // DOES NOT COMPILE
byte gloves = 7 * 100;  // DOES NOT COMPILE
```

Compaund operates can handle casting
```java
long goat = 10;
int sheep = 5;
sheep = sheep * goat;   // DOES NOT COMPILE
```

```java
long goat = 10;
int sheep = 5;
sheep *= goat;  // The compound operator will first cast sheep to a long, apply the multiplication of two long values, and then cast the result to an int. 
```

assignment with assignment
```java
long wolf = 5;
long coyote = (wolf=3);
System.out.println(wolf);   // 3
System.out.println(coyote); // 3
```
and as well
```java
long wolf = 5;
long coyote = (wolf=3);
long tiger = wolf = coyote = 10;
System.out.println(wolf);   // 10
System.out.println(coyote); // 10
 System.out.println(tiger); // 10
```

```java
boolean healthy = false;
if(healthy = true)
   System.out.print("Good!");
```


```java
public class CandyCounter {
   static long addCandy(double fruit, float vegetables) {
      return (int)fruit+vegetables;                         // doesn't compile because result will be float and float not casting to long
   }
   
   public static void main(String[] args) {
      System.out.print(addCandy(1.4, 2.4f) + ", ");
      System.out.print(addCandy(1.9, (float)4) + ", ");
      System.out.print(addCandy((long)(int)(short)2, (float)4)); } } // correct
```

# Comparison

>The equality operator can be applied to numeric values, boolean values, and objects (including String and null). When applying the equality operator, you cannot mix these types. I.E it's legal to compare different numeric types with each other.


```java
boolean monkey = true == 3;       // DOES NOT COMPILE
boolean ape = false != "Grape";   // DOES NOT COMPILE
boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE
boolean a = 34L == 3.9f;
```

```java
boolean bear = false;
boolean polar = (bear = true);
System.out.println(polar);  // true
```

```java
var monday = new File("schedule.txt");
var tuesday = new File("schedule.txt");
var wednesday = tuesday;
System.out.println(monday == tuesday);    // false
System.out.println(tuesday == wednesday); // true
```

```java
System.out.print(null == null);  // true
```

> If the compiler can determine that a variable cannot possibly be cast to a specific class, it reports an error.

```java
public void openZoo(Number time) {
   if(time instanceof String) // DOES NOT COMPILE
      System.out.print(time);
}
```

```java
System.out.print(null instanceof Object);  // false
 
Object noObjectHere = null;
System.out.print(noObjectHere instanceof String);  // false
System.out.print(null instanceof null);  // DOES NOT COMPILE
```

```java
if(duck!=null & duck.getAge()<5) { // Could throw a NullPointerException
   // Do something
}
```

```java
if(duck!=null && duck.getAge()<5) {
   // Do something
}
```

```java
int ph = 7, vis = 2;
boolean clear = vis ˃ 1 & (vis ˂ 9 || ph ˂ 2);
boolean safe = (vis ˃ 2) && (ph++ ˃ 1);                 // right side never invokes
boolean tasty = 7 ˂= --ph;
System.out.println(clear + "-" + safe + "-" + tasty);  // true, false, false 
```

# Ternary Operator tricks

```java
int food1 = owl < 4 ? owl > 2 ? 3 : 4 : 5;
int food2 = (owl < 4 ? ((owl > 2) ? 3 : 4) : 5)
```

> there is no requirement that second and third expressions in ternary operations have the same data types, although it does come into play when combined with the assignment operator
```java
int stripes = 7;
 
System.out.print((stripes > 5) ? 21 : "Zebra");
 
int animal = (stripes < 9) ? 3 : "Horse";  // DOES NOT COMPILE
```

```java
int sheep = 1;
int zzz = 1;
int sleep = zzz < 10 ? sheep++ : zzz++;
System.out.print(sleep + "," + sheep + "," + zzz);  // 1,2,1
```    

```java
int sheep = 1;
int zzz = 1;
int sleep = sheep>=10 ? sheep++ : zzz++;
System.out.print(sleep + "," + sheep + "," + zzz);  // 1,1,2
```    

# Pattern matching 

Для избежания проверки на тип, а потом приведения к типу с Java 16 появилось это. Переменная data относится к так называемым *pattern variable*.
```java
void compareIntegers(Number number) {
   if(number instanceof Integer data) {
      System.out.print(data.compareTo(5));
   }
}
```

pattern variable можно переприсвоить, если не обьявлено final
```java
if(number instanceof Integer data) {
   data = 10;
}
```

```java
if(number instanceof final Integer data) {
   data = 10;  // DOES NOT COMPILE
}
```

pattern variable переменную можно использовать дальше в выражениях в том же выражении
```java
void printIntegersGreaterThan5(Number number) {
   if(number instanceof Integer data && data.compareTo(5)>0)
      System.out.print(data);
}
```
важное ограничение, pattern varialble должно быть подтипом в отличие от традиционного instanceof
```java
Integer value = 123;
if(value instanceof Integer) {}
if(value instanceof Integer data) {}  // DOES NOT COMPILE
```

следует различать ситуации, когда pattern variable может не обьявиться перед использонием. Компиллятор следит за эти не даст коду такому скомпилироваться.

```java
void printIntegersOrNumbersGreaterThan5(Number number) {
   if(number instanceof Integer data || data.compareTo(5)>0)  // DOES NOT COMPILE
      System.out.print(data);
}
```

Скоуп видимости не ограничен ифом. Может вылезти дальше, если компилятор решит что переменная точно определена.
```java
void printOnlyIntegers(Number number) { 
   if (!(number instanceof Integer data))
      return;
   System.out.print(data.intValue());
}
```

# switch

## switch statement

![Switch](images/switch_1.png)

 - `default` может быть где угодно среди case. В том числе кейсов может и не быть, а default при этом будет работать. Более того может быть вообще ничего внутри скобок
 - Если после значения идет `:` далее может идти как блок так и последовательность выражение разделенных `;`

```java
switch (random) {
       case 4:
        System.out.println("first");
        System.out.println("second");
        break;
    case 5: {
        System.out.println("third");
        System.out.println("other");
        break;
    }
}
```        

- допускается пустой switch
```java
switch(month) {}
```

The following is a list of all data types supported by switch statements:

- `int` and `Integer`
- `byte` and `Byte`
- `short` and `Short`
- `char` and `Character`
- `String`
- `enum` values
- `var` (if the type resolves to one of the preceding types)

Notice that `boolean`, `long`, `float`, and `double` are excluded from switch statements, as are their associated `Boolean`, `Long`, `Float`, and `Double` classes

обратить внимание на использование нескольких значений в одном `case`. Появилось в Java 14
```java
switch(animal) {
   case 1,2: System.out.print("Lion");
   case 3:   System.out.print("Tiger");
}
```
ранее нужно было писать так

```java
switch(animal) {
   case 1: case 2: System.out.print("Lion");
   case 3:         System.out.print("Tiger");
}
``` 

```java
public void printSeason(int month) {
   switch(month) {
      case 1, 2, 3:    System.out.print("Winter");
      case 4, 5, 6:    System.out.print("Spring");
      default:         System.out.print("Unknown");
      case 7, 8, 9:    System.out.print("Summer");
      case 10, 11, 12: System.out.print("Fall");
   } 
}
```

В case можно писать только константы и значения, которые известны в момент компиляции. 
```java
final int getCookies() { return 4; }
void feedAnimals() {
   final int bananas = 1;
   int apples = 2;
   int numberOfAnimals = 3;
   final int cookies = getCookies();
   switch(numberOfAnimals) {
      case bananas:
      case apples:        // DOES NOT COMPILE
      case getCookies():  // DOES NOT COMPILE
      case cookies :      // DOES NOT COMPILE
      case 3 * 5 :
   } }
```   



## Switch expression. Новый switch, который может возвращать значения
![Switch](images/switch_2.png)

- После оператора `->` идет НЕ лямбда. 
- После значений через зяпутую идет оператор `->` а не двоеточие `:`
- обязателен `;` если используется не блок кода а одно выражение.
- Обязателен `;` после всего switch, так как есть присвоение к переменной результата switch
- Не нужен `break` ветки исполняются только если case совпадает.
- Если используется блок кода, после всего блока запрещено ставить `;` 
```java
public void printDayOfWeek(int day) {
   var result = switch(day) {
      case 0 -> "Sunday";
      case 1 -> "Monday";
      case 2 -> "Tuesday";
      case 3 -> "Wednesday";
      case 4 -> "Thursday";
      case 5 -> "Friday";
      case 6 -> "Saturday";
      default -> "Invalid value";
   };
   System.out.print(result);
}
```

тут нет присвоения к переменной. 
```java
public void printSeason(int month) {
   switch(month) {
      case 1, 2, 3    -> System.out.print("Winter");
      case 4, 5, 6    -> System.out.print("Spring");
      case 7, 8, 9    -> System.out.print("Summer");
      case 10, 11, 12 -> System.out.print("Fall");
   } 
}
```   

1. All of the branches of a switch expression that do not throw an exception must return a consistent data type (if the switch expression returns a value).

      ```java
      int measurement = 10;
      int size = switch(measurement) {
         case 5 -> 1;
         case 10 -> (short)2;
         default -> 5;
         case 20 -> "3";   // DOES NOT COMPILE
         case 40 -> 4L;    // DOES NOT COMPILE
         case 50 -> null;  // DOES NOT COMPILE
      };
      ```

2. If the switch expression returns a value, then every branch that isn't an expression must yield a value.

```java
int fish = 5;
int length = 12;
var name = switch(fish) {
   case 1 -> "Goldfish";
   case 2 -> {yield "Trout";}
   case 3 -> {
      if(length > 10) yield "Blobfish";
      else yield "Green";
   }
   default -> "Swordfish";
};
```

```java
int fish = 5;
int length = 12;
var name = switch(fish) {
   case 1 -> "Goldfish";
   case 2 -> {}  // DOES NOT COMPILE
   case 3 -> {
      if(length > 10) yield "Blobfish";
   }  // DOES NOT COMPILE
   default -> "Swordfish";
};
```

3. A default branch is required unless all cases are covered or no value is returned.

```java
String type = switch(canis) { // DOES NOT COMPILE
   case 1 -> "dog";
   case 2 -> "wolf";
   case 3 -> "coyote";
};
```
Есть два способа исправить:
1. Добавить default ветку.
2. If the switch expression takes an enum value, add a case branch for every possible enum value.

```java
enum Season {WINTER, SPRING, SUMMER, FALL}
 
String getWeather(Season value) {
   return switch(value) {
      case WINTER -> "Cold";
      case SPRING -> "Rainy";
      case SUMMER -> "Hot";
      case FALL -> "Warm";
   };
}
```

- При использование энумов со switch рекомендуется рассмотреть использользование default ветку тоже, даже при том, что она необязательная. Если в энум добавить выражение, код не скомпилируется, если таких switch много потребуется много правок. 

# Cycles

## do while
Обязателено ставить `;` после условия do while цикла
```java
int lizard = 0;
do {
   lizard++;
} while(false);
System.out.println(lizard);  // 1
```

## for

Блоки могут быть составными, тогда нужно писать через запятую внутри них.

Блоки опциональны. Вот это бесконечный цикл. Обязательны `;` между блоками
```java
for( ; ; )
   System.out.println("Hello World");
```
такое не скомпилируется `for( )`


видимость переменных
```java
for(int i=0; i < 10; i++)
   System.out.println("Value is: "+i);
System.out.println(i);  // DOES NOT COMPILE
```

```java
int i;
for(i=0; i < 10; i++)
   System.out.println("Value is: "+i);
System.out.println(i);
```

correct
```java
int x = 0;
for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
   System.out.print(y + " "); }
System.out.print(x + " ");
```

not corret
```java
int x = 0;
for(long y = 0, int z = 4; x < 5; x++)  // DOES NOT COMPILE
   System.out.print(y + " ");

```java
int x = 0;
for(int x = 4; x < 5; x++)   // DOES NOT COMPILE
   System.out.print(x + " ");
```

# Labels

Метки могут помещены перед `if`, `switch` и всеми циклами.

```java
int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
 
OUTER_LOOP:  for(int[] mySimpleArray : myComplexArray) {
   INNER_LOOP:  for(int i=0; i<mySimpleArray.length; i++) {
      System.out.print(mySimpleArray[i]+"\t");
   }
   System.out.println();
}
```

также метки могут быть перед любым блоком
```java
int frog = 15;
BAD_IDEA: if(frog>10)
EVEN_WORSE_IDEA: {
   frog++;
}
```

`break` with label
```java
public class FindInMatrix {
   public static void main(String[] args) {
      int[][] list = {{1,13},{5,2},{2,2}};
      int searchValue = 2;
      int positionX = -1;
      int positionY = -1;
 
      PARENT_LOOP: for(int i=0; i<list.length; i++) {
         for(int j=0; j<list[i].length; j++) {
            if(list[i][j]==searchValue) {
               positionX = i;
               positionY = j;
               break PARENT_LOOP;
            }
         }
      }
      if(positionX==-1 || positionY==-1) {
         System.out.println("Value "+searchValue+" not found");
      } else {
         System.out.println("Value "+searchValue+" found at: " +
            "("+positionX+","+positionY+")");
      }
   }
}
```

you can interrupt cycles using `return`
```java
   private static int[] searchForValue(int[][] list, int v) {
      for (int i = 0; i < list.length; i++) {
         for (int j = 0; j < list[i].length; j++) {
            if (list[i][j] == v) {
               return new int[] {i,j};
            }
         }
      }
      return null;
   }
```   


`continue` with label
```java
public class CleaningSchedule {
   public static void main(String[] args) {
      CLEANING: for(char stables = 'a'; stables<='d'; stables++) {
         for(int leopard = 1; leopard<4; leopard++) {
            if(stables=='b' || leopard==2) {
               continue CLEANING;
            }
            System.out.println("Cleaning: "+stables+","+leopard);
} } } }
```

unrecheable code for break, continue, return
```java
int checkDate = 0;
while(checkDate<10) {
   checkDate++;
   if(checkDate>100) {
      break;
      checkDate++;  // DOES NOT COMPILE
   }
}

int minute = 1;
WATCH: while(minute>2) {
   if(minute++>2) {
      continue WATCH;
      System.out.print(minute);  // DOES NOT COMPILE
   }
}
 
int hour = 2;
switch(hour) {
   case 1: return; hour++;  // DOES NOT COMPILE
   case 2:
}
```
# Strings

## String concatination

Rules:
- If both operands are numeric, + means numeric addition.
- If either operand is a String, + means concatenation.
- The expression is evaluated left to right.

```java
System.out.println(1 + 2);           // 3
System.out.println("a" + "b");       // ab
System.out.println("a" + "b" + 3);   // ab3
System.out.println(1 + 2 + "c");     // 3c
System.out.println("c" + 1 + 2);     // c12
System.out.println("c" + null);      // cnull
```

```java
int three = 3;
String four = "4";
System.out.println(1 + 2 + three + four);
```

## important methods for OCP exam
```java
public int length()

public char charAt(int index)

public int indexOf(int ch) 
public int indexOf(int ch, int fromIndex)
public int indexOf(String str)
public int indexOf(String str, int fromIndex)

public String substring(int beginIndex)
public String substring(int beginIndex, int endIndex)

public String toLowerCase()
public String toUpperCase()

public boolean equals(Object obj)
public boolean equalsIgnoreCase(String str)

public boolean startsWith(String prefix)
public boolean endsWith(String suffix)
public boolean contains(CharSequence charSeq)

public String replace(char oldChar, char newChar)
public String replace(CharSequence target, CharSequence replacement)

public String strip()
public String stripLeading()
public String stripTrailing()
public String trim()

public String indent(int numberSpaces)
public String stripIndent()

public String translateEscapes()

public boolean isEmpty()
public boolean isBlank()

public static String format(String format, Object args…)
public static String format(Locale loc, String format, Object args…)
public String formatted(Object args…)
```

```java
var name = "animals";
System.out.println(name.indexOf('a'));       // 0
System.out.println(name.indexOf("al"));      // 4
System.out.println(name.indexOf('a', 4));    // 4
System.out.println(name.indexOf("al", 5));   // -1
```

## substring 

```java
public String substring(int beginIndex)
public String substring(int beginIndex, int endIndex)
```

second argument in `substring` doesn't included. Such as math `[left_arg, right_arg)`
```java
var name = "animals";
System.out.println(name.substring(3));                 // mals
System.out.println(name.substring(name.indexOf('m'))); // mals
System.out.println(name.substring(3, 4));              // m
System.out.println(name.substring(3, 7));              // mals

System.out.println(name.substring(3, 3)); // empty string
System.out.println(name.substring(3, 2)); // exception
System.out.println(name.substring(3, 8)); // exception
```

## equals

```java
public boolean equals(Object obj)
public boolean equalsIgnoreCase(String str)
```

```java
System.out.println("abc".equals("ABC"));            // false
System.out.println("ABC".equals("ABC"));            // true
System.out.println("abc".equalsIgnoreCase("ABC"));  // true
```

## replace

```java
public String replace(char oldChar, char newChar)
public String replace(CharSequence target, CharSequence replacement)
```

```java
System.out.println("abcabc".replace('a', 'A')); // AbcAbc
System.out.println("abcabc".replace("a", "A")); // AbcAbc
```

## strip and trim

```java
public String strip()
public String stripLeading()
public String stripTrailing()
```

```java
System.out.println("abc".strip());                 // abc
System.out.println("\t   a b c\n".strip());        // a b c
 
String text = " abc\t ";
System.out.println(text.trim().length());          // 3
System.out.println(text.strip().length());         // 3
System.out.println(text.stripLeading().length());  // 5
System.out.println(text.stripTrailing().length()); // 4
```

## Working with indent

```java
public String indent(int numberSpaces)
public String stripIndent()
```

- The `indent()` method adds the same number of blank spaces to the beginning of each line if you pass a positive number. If you pass a negative number, it tries to remove that number of whitespace characters from the beginning of the line. If you pass zero, the indentation will not change.
- `indent()` also normalizes whitespace characters. What does normalizing whitespace mean, you ask? First, a line break is added to the end of the string if not already there. Second, any line breaks are converted to the \n format. Regardless of whether your operating system uses \r\n (Windows) or\n (Mac/Unix), Java will standardize on \n for you.
- The `stripIndent()` method is useful when a String was built with concatenation rather than using a text block. It gets rid of all incidental whitespace. This means that all non-blank lines are shifted left so the same number of whitespace characters are removed from each line and the first character that remains is not blank. Like indent(), \r\n is turned into \n. However, the stripIndent() method does not add a trailing line break if it is missing.

![Differences between indent and stripIndent](images/indent_and_stript_indent_diff_1.png)

```java
var block = """
            a
             b
            c""";
var concat = " a\n"
           + "  b\n"
           + " c";
System.out.println(block.length());                 // 6
System.out.println(concat.length());                // 9
System.out.println(block.indent(1).length());       // 10
System.out.println(concat.indent(-1).length());     // 7
System.out.println(concat.indent(-4).length());     // 6
System.out.println(concat.stripIndent().length());  // 6
```

## translateEscapes

```java
public String translateEscapes()
```

```java
var str = "1\\t2";
System.out.println(str);                    // 1\t2
System.out.println(str.translateEscapes()); // 1    2
```

> this method can be used for escape sequences such as \t (tab), \n (new line), \s (space), \" (double quote), and \' (single quote.)

## empty string
```java
public boolean isEmpty()
public boolean isBlank()
```

```java
System.out.println(" ".isEmpty()); // false
System.out.println("".isEmpty());  // true
System.out.println(" ".isBlank()); // true
System.out.println("".isBlank());  // true
```

## Formatting

```java
var name = "Kate";
var orderId = 5;
 
// All print: Hello Kate, order 5 is ready
System.out.println("Hello "+name+", order "+orderId+" is ready");
System.out.println(String.format("Hello %s, order %d is ready", 
   name, orderId));
System.out.println("Hello %s, order %d is ready"
   .formatted(name, orderId));
```

- `%s`	Applies to any type, commonly String values
- `%d`	Applies to integer values like int and long
- `%f`	Applies to floating-point values like float and double
- `%n`	Inserts a line break using the system-dependent line separator

```java
var name = "James";
var score = 90.25;
var total = 100;
System.out.println("%s:%n   Score: %f out of %d"
   .formatted(name, score, total));

/*
James:
   Score: 90.250000 out of 100
*/      
```

don't mix that types
```java
var str = "Food: %d tons".formatted(2.0); // IllegalFormatConversionException
```

> By default, %f displays exactly six digits past the decimal. If you want to display only one digit after the decimal, you can use %.1f instead of %f.

## StringBuilder

### Important methods

> <mark> StringBuild does not have overriden `equals` </mark>

```java

public String substring(int start, int end) 
public int length()
public char charAt(int index)
public int indexOf(String str)

public StringBuilder append(String str)
public StringBuilder insert(int offset, String str)
public StringBuilder delete(int startIndex, int endIndex)
public StringBuilder deleteCharAt(int index)
public StringBuilder replace(int startIndex, int endIndex, String newString)
public StringBuilder reverse()
```

```java
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = new StringBuilder("animal");
StringBuilder sb3 = new StringBuilder(10);
```

```java
StringBuilder sb = new StringBuilder("start");
sb.append("+middle"); // sb = "start+middle"
StringBuilder same = sb.append("+end"); // "start+middle+end"
```

```java
StringBuilder a = new StringBuilder("abc");
StringBuilder b = a.append("de");
b = b.append("f").append("g");
System.out.println("a=" + a);
System.out.println("b=" + b);
//only one StringBuilder here
```

```java
var one = new StringBuilder();
var two = new StringBuilder();
var three = one.append("a");
System.out.println(one == two);   // false
System.out.println(one == three); // true
```

### substring returns String




```java
var sb = new StringBuilder("animals");
String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
int len = sb.length();
char ch = sb.charAt(6);
System.out.println(sub + " " + len + " " + ch);
```

### append

```java
public StringBuilder append(String str)
```

```java
var sb = new StringBuilder().append(1).append('c');
sb.append("-").append(true);
System.out.println(sb);      // 1c-true
```

### insert
```java
public StringBuilder insert(int offset, String str)
```

```java
var sb = new StringBuilder("animals");
sb.insert(7, "-");                  // sb = animals-
sb.insert(0, "-");                  // sb = -animals-
sb.insert(4, "-");                  // sb = -ani-mals-
System.out.println(sb);
```

### delete
```java
public StringBuilder delete(int startIndex, int endIndex)
public StringBuilder deleteCharAt(int index)
```

```java
var sb = new StringBuilder("abcdef");
sb.delete(1, 3);                   // sb = adef
sb.deleteCharAt(5);                // exception
```

delete is method with no exception when we put too big right value
```java
var sb = new StringBuilder("abcdef");
sb.delete(1, 100);                  // sb = a
```

### replace

```java
public StringBuilder replace(int startIndex, int endIndex, String newString)
```

```java
var builder = new StringBuilder("pigeon dirty");
builder.replace(3, 6, "sty");
System.out.println(builder);  // pigsty dirty
// First, Java deletes the characters starting with index 3 and ending right before index 6. This gives us pig dirty. Then Java inserts the value "sty" in that position.

var builder = new StringBuilder("pigeon dirty");
builder.replace(3, 100, "");
System.out.println(builder); // pig

```

### reverse

```java
public StringBuilder reverse()
```
```java
var sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb);
```

## String pool

The string pool, also known as the intern pool, is a location in the Java Virtual Machine (JVM) that collects all these strings.

```java
var x = "Hello World";
var y = "Hello World";
System.out.println(x == y); // true
```

```java
var x = "Hello World";
var z = " Hello World".trim();
System.out.println(x == z); // false
```

```java
var singleString = "hello world";
var concat = "hello ";
concat += "world";
System.out.println(singleString == concat); // false
```

```java
var x = "Hello World";
var y = new String("Hello World");
System.out.println(x == y); // false
```

The intern() method will use an object in the string pool if one is present.

```java
public String intern()
```

```java
var name = "Hello World";
var name2 = new String("Hello World").intern();
System.out.println(name == name2); // true
```

Tricky. Concatenation of literals is just literal because compiler insert in byte code just one string. Except += like above. 
```java
var first = "rat" + 1;
var second = "r" + "a" + "t" + "1";
var third = "r" + "a" + "t" + new String("1");
System.out.println(first == second);          // true
System.out.println(first == second.intern()); // true
System.out.println(first == third);           // false
System.out.println(first == third.intern());  // true
```

# Arrays

The array does not allocate space for the objects. Instead, it allocates space for a reference to where the objects are really stored.

anonymous array
```java
int[] moreNumbers = new int[] {42, 55, 99};

int[] moreNumbers = {42, 55, 99};
```

```java
int[] numAnimals;
int [] numAnimals2;
int []numAnimals3;
int numAnimals4[];
int numAnimals5 [];
```

```java
int[] ids, types; 
  ```

```java
String[] strings = { "stringValue" };
Object[] objects = strings;
String[] againStrings = (String[]) objects;
againStrings[0] = new StringBuilder();   // DOES NOT COMPILE
objects[0] = new StringBuilder();        // ArrayStoreException in runtime
```

```java
String[] mammals = {"monkey", "chimp", "donkey"};
System.out.println(mammals.length());               // DOES NOT COMPILE
```

## Sort

```java
int[] numbers = { 6, 9, 1 };
Arrays.sort(numbers);
for (int i = 0; i < numbers.length; i++)
   System.out.print(numbers[i] +  " ");  // 1 6 9
```

```java
String[] strings = { "10", "9", "100" };
Arrays.sort(strings);
for (String s : strings)
   System.out.print(s + " "); // 10 100 9
```

## Search

Negative value showing one smaller than the negative of the index, where a match needs to be inserted to preserve sorted order

```java
int[] numbers = {2,4,6,8};
System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 4)); // 1
System.out.println(Arrays.binarySearch(numbers, 1)); // -1
System.out.println(Arrays.binarySearch(numbers, 3)); // -2
System.out.println(Arrays.binarySearch(numbers, 9)); // -5
```

Unsorted array	A surprise; this result is undefined

## Compare

```java
System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));
```

compare return values: 
- A negative number means the first array is smaller than the second.
- A zero means the arrays are equal.
- A positive number means the first array is larger than the second.

rules:
- If both arrays are the same length and have the same values in each spot in the same order, return zero.
- If all the elements are the same but the second array has extra elements at the end, return a negative number.
- If all the elements are the same, but the first array has extra elements at the end, return a positive number.
- If the first element that differs is smaller in the first array, return a negative number.
- If the first element that differs is larger in the first array, return a positive number.
- `null` is smaller than any other value.
- For numbers, normal numeric order applies.
- For strings, one is smaller if it is a prefix of another.
- For strings/characters, numbers are smaller than letters.
- For strings/characters, uppercase is smaller than lowercase.

![Array comparison example](images/array_comparison_1.png)

```java
System.out.println(Arrays.compare(
   new int[] {1}, new String[] {"a"})); // DOES NOT COMPILE
```

## Mismatch

If the arrays are equal, `mismatch()` returns `-1`. Otherwise, it returns the first index where they differ. 

```java
System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1})); // -1
System.out.println(Arrays.mismatch(new String[] {"a"},             // 0
   new String[] {"A"}));
System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1})); // 1
```

## Multidimensional Array

```java
int[][] vars1;          // 2D array
int vars2 [][];         // 2D array
int[] vars3[];          // 2D array
int[] vars4 [], space [][];  // a 2D AND a 3D array

String [][] rectangle = new String[3][2];

int[][] differentSizes = {{1, 4}, {3}, {9,8,7}};

int [][] args = new int[4][];
args[0] = new int[5];
args[1] = new int[3];
```

```java
var twoD = new int[3][2];
for(int i = 0; i < twoD.length; i++) {
   for(int j = 0; j < twoD[i].length; j++)
      System.out.print(twoD[i][j] + " "); // print element
   System.out.println();                  // time for a new row
}

for(int[] inner : twoD) {
   for(int num : inner)
      System.out.print(num + " ");
   System.out.println();
}
```

# Math APIs

## min max

```java
public static double min(double a, double b)
public static float min(float a, float b)
public static int min(int a, int b)
public static long min(long a, long b)
```

```java
int first = Math.max(3, 7);   // 7
int second = Math.min(7, -9); // -9
```

## round

If the fractional part is .5 or higher, we round up.

```java
public static long round(double num)
public static int round(float num)
```

```java
long low = Math.round(123.45);       // 123
long high = Math.round(123.50);      // 124
int fromFloat = Math.round(123.45f); // 123
```

## Ceil and floor

The `ceil()` method takes a `double` value. If it is a whole number, it returns the same value. If it has any fractional value, it rounds up to the **next** whole number. 

By contrast, the `floor()` method discards any values after the decimal.

```java
public static double ceil(double num)
public static double floor(double num)
```

```java
double c = Math.ceil(3.14);  // 4.0
double f = Math.floor(3.14); // 3.0 
```

## Pow

```java
public static double pow(double number, double exponent)
```

```java
double squared = Math.pow(5, 2); // 25.0
```

## random

```java
public static double random()
```

```java
double num = Math.random(); // greater than or equal to 0 and less than 1
```

# Working with Dates and Times

New modern Java Time classes
```java
 import java.time.*;    // import time classes
 ```

- `LocalDate` Contains just a date—no time and no time zone. A good example of LocalDate is your birthday this year. It is your birthday for a full day, regardless of what time it is
- `LocalTime` Contains just a time—no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.
- `LocalDateTime` Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year's Eve.” Midnight on January 2 isn't nearly as special, making the date relatively unimportant, and clearly an hour after midnight isn't as special either.
- `ZonedDateTime` Contains a date, time, and time zone. A good example of ZonedDateTime is “a conference call at 9:00 a.m. EST.” If you live in California, you'll have to get up really early since the call is at 6:00 a.m. local time!

```java
System.out.println(LocalDate.now());  // 2021–10–25
System.out.println(LocalTime.now());   //09:13:07.768
System.out.println(LocalDateTime.now());  //2021–10–25T09:13:07.768 devided by T
System.out.println(ZonedDateTime.now());  //2021–10–25T09:13:07.769–05:00[America/New_York]
```

```java
var d = new LocalDate(); // DOES NOT COMPILE Only static methods
```

```java
var d = LocalDate.of(2022, Month.JANUARY, 32) // DateTimeException
```

## LocalDate

```java
public static LocalDate of(int year, int month, int dayOfMonth)
public static LocalDate of(int year, Month month, int dayOfMonth)
```

```java
var date1 = LocalDate.of(2022, Month.JANUARY, 20);
var date2 = LocalDate.of(2022, 1, 20);
```

## LocalTime

```java
public static LocalTime of(int hour, int minute)
public static LocalTime of(int hour, int minute, int second)
public static LocalTime of(int hour, int minute, int second, int nanos)
```

```java
var time1 = LocalTime.of(6, 15);              // hour and minute
var time2 = LocalTime.of(6, 15, 30);          // + seconds
var time3 = LocalTime.of(6, 15, 30, 200);     // + nanoseconds
```

## LocalDateTime

```java
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute)
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second)
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos)

public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanos)

public static LocalDateTime of(LocalDate date, LocalTime time)
```

```java
var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
var dateTime2 = LocalDateTime.of(date1, time1);
```

## ZonedDateTime

```java
public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
```

```java
var zone = ZoneId.of("US/Eastern");
var zoned1 = ZonedDateTime.of(2022, 1, 20,
       6, 15, 30, 200, zone);
var zoned2 = ZonedDateTime.of(date1, time1, zone);
var zoned3 = ZonedDateTime.of(dateTime1, zone);
```

## Manipulating date and times

> All date time api classes are immutable. So don't forget to assign the result of manipulation to a reference

```java
var date = LocalDate.of(2022, Month.JANUARY, 20);
System.out.println(date);    // 2022–01–20
date = date.plusDays(2);
System.out.println(date);    // 2022–01–22
date = date.plusWeeks(1);
System.out.println(date);    // 2022–01–29
date = date.plusMonths(1);
System.out.println(date);    // 2022–02–28
date = date.plusYears(5);
System.out.println(date);    // 2027–02–28
```

```java
var date = LocalDate.of(2024, Month.JANUARY, 20);
var time = LocalTime.of(5, 15);
var dateTime = LocalDateTime.of(date, time);
System.out.println(dateTime);       // 2024–01–20T05:15
dateTime = dateTime.minusDays(1);
System.out.println(dateTime);       // 2024–01–19T05:15
dateTime = dateTime.minusHours(10);
System.out.println(dateTime);       // 2024–01–18T19:15
dateTime = dateTime.minusSeconds(30);
System.out.println(dateTime);       // 2024–01–18T19:14:30
```

or with chain
```java
var date = LocalDate.of(2024, Month.JANUARY, 20);
var time = LocalTime.of(5, 15);
var dateTime = LocalDateTime.of(date, time)
       .minusDays(1).minusHours(10).minusSeconds(30);
```       

```java
var date = LocalDate.of(2024, Month.JANUARY, 20);
date.plusDays(10);
System.out.println(date);  // January 20, 2024.
```

```java
var date = LocalDate.of(2024, Month.JANUARY, 20);
date = date.plusMinutes(1);       // DOES NOT COMPILE
```

## Period

```java
public static void main(String[] args) {
   var start = LocalDate.of(2022, Month.JANUARY, 1);
   var end = LocalDate.of(2022, Month.MARCH, 30);
   performAnimalEnrichment(start, end);
}
private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
   var upTo = start;
   while (upTo.isBefore(end)) { // check if still before end
      System.out.println("give new toy: " + upTo);
      upTo = upTo.plusMonths(1); // add a month
} }
```

with `Period` is more reusable

```java
public static void main(String[] args) {
   var start = LocalDate.of(2022, Month.JANUARY, 1);
   var end = LocalDate.of(2022, Month.MARCH, 30);
   performAnimalEnrichment(start, end);
}
private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
   var upTo = start;
   while (upTo.isBefore(end)) { // check if still before end
      System.out.println("give new toy: " + upTo);
      upTo = upTo.plusMonths(1); // add a month
} }
```

```java
var annually = Period.ofYears(1);            // every 1 year
var quarterly = Period.ofMonths(3);          // every 3 months
var everyThreeWeeks = Period.ofWeeks(3);     // every 3 weeks
var everyOtherDay = Period.ofDays(2);        // every 2 days
var everyYearAndAWeek = Period.of(1, 0, 7);  // every year and 7 days
```

chain doesn't work because of static method

```java
var wrong = Period.ofYears(1).ofWeeks(1); // every week
```

```java
var date = LocalDate.of(2022, 1, 20);
var time = LocalTime.of(6, 15);
var dateTime = LocalDateTime.of(date, time);
var period = Period.ofMonths(1);
System.out.println(date.plus(period));     // 2022–02–20
System.out.println(dateTime.plus(period)); // 2022–02–20T06:15
System.out.println(time.plus(period));     // Exception
```

## Duration

```java
var daily = Duration.ofDays(1);               // PT24H
var hourly = Duration.ofHours(1);             // PT1H
var everyMinute = Duration.ofMinutes(1);      // PT1M
var everyTenSeconds = Duration.ofSeconds(10); // PT10S
var everyMilli = Duration.ofMillis(1);        // PT0.001S
var everyNano = Duration.ofNanos(1);          // PT0.000000001S
```

```java
var daily = Duration.of(1, ChronoUnit.DAYS);
var hourly = Duration.of(1, ChronoUnit.HOURS);
var everyMinute = Duration.of(1, ChronoUnit.MINUTES);
var everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
var everyMilli = Duration.of(1, ChronoUnit.MILLIS);
var everyNano = Duration.of(1, ChronoUnit.NANOS);
```

how to calculate difference between temporal values
```java
var one = LocalTime.of(5, 15);
var two = LocalTime.of(6, 30);
var date = LocalDate.of(2016, 1, 20);
System.out.println(ChronoUnit.HOURS.between(one, two));     // 1
System.out.println(ChronoUnit.MINUTES.between(one, two));   // 75
System.out.println(ChronoUnit.MINUTES.between(one, date));  // DateTimeException
```

```java
LocalTime time = LocalTime.of(3,12,45);
System.out.println(time);      // 03:12:45
LocalTime truncated = time.truncatedTo(ChronoUnit.MINUTES);
System.out.println(truncated); // 03:12
```

```java
var date = LocalDate.of(2022, 1, 20);
var time = LocalTime.of(6, 15);
var dateTime = LocalDateTime.of(date, time);
var duration = Duration.ofHours(6);
System.out.println(dateTime.plus(duration));  // 2022–01–20T12:15
System.out.println(time.plus(duration));      // 12:15
System.out.println(
   date.plus(duration));  // UnsupportedTemporalTypeException
```

```java
var date = LocalDate.of(2022, 1, 20);
var time = LocalTime.of(6, 15);
var dateTime = LocalDateTime.of(date, time);
var duration = Duration.ofHours(23);
System.out.println(dateTime.plus(duration));  // 2022–01–21T05:15
System.out.println(time.plus(duration));      // 05:15
System.out.println(
   date.plus(duration));  // UnsupportedTemporalTypeException
```

## Period vs Duration

```java
var date = LocalDate.of(2022, 5, 25);
var period = Period.ofDays(1);
var days = Duration.ofDays(1);
 
System.out.println(date.plus(period));   // 2022–05–26
System.out.println(date.plus(days));     // Unsupported unit: Seconds
```

## Instant

The `Instant` class represents a specific moment in time in the GMT time zone.

```java
var now = Instant.now();
// do something time consuming
var later = Instant.now();
 
var duration = Duration.between(now, later);
System.out.println(duration.toMillis());  // Returns number milliseconds
```

you can convert `ZonedDateTime` to `Instant`

```java
var date = LocalDate.of(2022, 5, 25);
var time = LocalTime.of(11, 55, 00);
var zone = ZoneId.of("US/Eastern");
var zonedDateTime = ZonedDateTime.of(date, time, zone);
var instant = zonedDateTime.toInstant(); // 2022–05–25T15:55:00Z
System.out.println(zonedDateTime); // 2022–05–25T11:55–04:00[US/Eastern]
System.out.println(instant); // 202–05–25T15:55:00Z
```

## Daylight saving

![Daylight saving](images/daylight-saving.png)

```java
var date = LocalDate.of(2022, Month.MARCH, 13);
var time = LocalTime.of(1, 30);
var zone = ZoneId.of("US/Eastern");
var dateTime = ZonedDateTime.of(date, time, zone);
System.out.println(dateTime);  // 2022–03-13T01:30-05:00[US/Eastern]
System.out.println(dateTime.getHour()); // 1
System.out.println(dateTime.getOffset()); // -05:00
 
dateTime = dateTime.plusHours(1);
System.out.println(dateTime);  // 2022–03-13T03:30-04:00[US/Eastern]
System.out.println(dateTime.getHour()); // 3
System.out.println(dateTime.getOffset()); // -04:00
```

```java
var date = LocalDate.of(2022, Month.NOVEMBER, 6);
var time = LocalTime.of(1, 30);
var zone = ZoneId.of("US/Eastern");
var dateTime = ZonedDateTime.of(date, time, zone);
System.out.println(dateTime); // 2022-11-06T01:30-04:00[US/Eastern]
 
dateTime = dateTime.plusHours(1);
System.out.println(dateTime); // 2022-11-06T01:30-05:00[US/Eastern]
 
dateTime = dateTime.plusHours(1);
System.out.println(dateTime); // 2022-11-06T02:30-05:00[US/Eastern]
```

```java
var date = LocalDate.of(2022, Month.MARCH, 13);
var time = LocalTime.of(2, 30);
var zone = ZoneId.of("US/Eastern");
var dateTime = ZonedDateTime.of(date, time, zone);
System.out.println(dateTime);    // 2022–03–13T03:30–04:00[US/Eastern]
```

# Data races

example from String class:

The hash or hashIsZero fields are subject to a benign data race,
making it crucial to ensure that any observable result of the
calculation in this method stays correct under any possible read of
these fields. Necessary restrictions to allow this to be correct
without explicit memory fences or similar concurrency primitives is
that we can ever only write to one of these two fields for a given
String instance, and that the computation is idempotent and derived
from immutable state

хорошая задачка попросить проанализировать корректную синхронизацию и возможность гонок.
```java

public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence,
               Constable, ConstantDesc {

    private final byte[] value;
    private int hash;
    private boolean hashIsZero; // Default to false;

public int hashCode() {
    int h = hash;
    if (h == 0 && !hashIsZero) {
        h = isLatin1() ? StringLatin1.hashCode(value)
                       : StringUTF16.hashCode(value);
        if (h == 0) {
            hashIsZero = true;
        } else {
            hash = h;
        }
    }
    return h;
}

}
```