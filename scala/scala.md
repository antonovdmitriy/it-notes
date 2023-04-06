# Links

- [Docs](https://www.scala-lang.org/api/current/)
- [Scala official project on Github](https://github.com/scala/scala)
- [MUnit library for scala testing](https://scalameta.org/munit/)


# sbt

Tool to compile and build scala applications.

```
$ sbt
> help      # Describe commands.
> tasks     # Show the most commonly used, available tasks.
> tasks -V  # Show ALL the available tasks.
> compile   # Incrementally compile the code.
> test      # Incrementally compile the code and run the tests.
> clean     # Delete all build artifacts.
> console   # Start the interactive Scala environment.
> run       # Run one of the "main" methods (applications) in the project.
> show x    # Show the value of setting or task "x".
> exit      # Quit the sbt shell (also control-d works).
```

# Main class and singleton

```scala
object Main {
  def main(args: Array[String]): Unit = {

  }
}
```

Declaring `Main` as an `object` makes it a singleton, meaning there will always be only one instance of it, which the Scala runtime will create for us. You can’t create your own instances with `new`.

```scala
object MyObject {                  
  val a = new MyClass("Scala")     
  println(a.sayHello("Martin"))
}
```


# Comments

- `//` comment goes to the end of a line, 
- `/* comment */` multiline comment
- `/** comment */`  Scaladoc documentation

# Conventions

- Scala packages, names, and file organization mostly follow Java conventions. But in one file it is possible to have more than one public class

```scala
class Employee(name: String, company: String, department: Department)

class Department(name: String)
```

- Scala allows angle brackets `<>` to be used in identifiers, like method and variable names. For example, defining a “less than” method and naming it `<` is common. To avoid ambiguity, Scala reserves square brackets for parameterized types so that characters like `<` and `>` can be used as identifiers.

- Value and variable names, by convention, should start with a lowercase letter and then capitalize additional words. This is popularly known as camel case, and though not required it is recommended for all Scala developers. This helps to distinguish them from types and classes which (also by convention, not by rule) follow camel case but start with an uppercase letter.

# Quick facts

- all members public by default
- type after colon and name of variable like this `name: String`

# Var and val

- A value is an immutable, typed storage unit. A value can be assigned data when it is defined, but can never be reassigned. 
  
```scala
val age: Int = 4;
age = 44; // DOES NOT COMPILE
```

- A variable is a mutable, typed storage unit. A variable can be assigned data when it is defined and can also be reassigned data at any time.

```scala
var ageMutable: Int = 44;
ageMutable = age;
```

## lazy val 

only val can be lazy, not var

```scala
    lazy val a: Integer = {
      println("evaluated"); 5
    }

    println(a)    // evaluated \n 5
    println(a)    // 5
```

```scala
val a = 1 + b;
val b = 19

println(a) // forward reference to value b defined on line 6 extends over definition of value a
```

```scala
lazy val a = 1 + b;
lazy val b = 19

println(a)
```

# Basics

Method definitions start with the `def` keyword, followed by the method name and an optional parameter list. The method signature ends with an optional return type. The return type can be inferred in many cases, but adding the return type explicitly, as shown, provides useful documentation for the reader and also avoids occasional surprises from the type inference process.

```scala
  def convert(strings: Seq[String]): Seq[String] =
    strings.map((s: String) => s.toUpperCase)
```
Type definitions are specified using name: type syntax. The parameter list is `strings: Seq[String]` and the return type of the method is `Seq[String]`, after the parameter list.

Collection types like `Seq[T]` are parameterized types, where `T` is the type of the elements in the sequence. Scala uses square brackets `[…]` for parameterized types, whereas several other languages use angle brackets `<…>`.

The function passed to the map method to do the transformation is an unnamed (anonymous) function literal of the form `(parameters) => body`
```scala
(s: String) => s.toUpperCase
```

It takes a parameter list with a single `String` named `s`. The body of the function literal is after the “arrow” `=>`. The body calls the `toUpperCase` method on `s`. The result of this call is automatically returned by the function literal. 

In Scala, the last expression in a function, method, or other block is the return value. (The `return` keyword exists in Scala, but it can only be used in methods, not in anonymous functions like this one. It is only used for early returns in the middle of methods

```scala
class Upper1 {
  def convert(strings: Seq[String]): Seq[String] =
    strings.map((s: String) => s.toUpperCase)
}

object Main {
    def main(args: Array[String]): Unit = {
      val upper: Upper1 = new Upper1()
      val uppers = upper.convert(List("one", "two"))
      println(uppers)
    }
}
```

Note that the type of the return value of main method is `Unit`. For now, think of Unit as analogous to void in other languages, meaning nothing useful is returned.

## To uppercase examples

```scala
object ArgsToUpperCase {
  def main(params: Array[String]): Unit = {
    print("ArgsToUpperCase.main: ")

    params.map(s => s.toUpperCase).foreach(s => printf("%s ", s))
    println("")

    params.map((s: String) => s.toUpperCase()).foreach(s => printf("%s ", s))
    println("")

    val output = params.map(_.toUpperCase()).mkString(" ")
    println(output)
  }
}
```

# Auto import common methods

 Scala automatically imports many commonly used types and object members, like `Seq`, `List`, `Vector`, and the `print*` methods we used, which are actually methods in an object called `scala.Console`. Most of these things that are automatically imported are defined in a library object called `Predef`.

 # Types

  - there is no concept of a primitive type in Scala

<table style="border-collapse: collapse; border-top: 0.5pt solid ; border-bottom: 0.5pt solid ; border-left: 0.5pt solid ; border-right: 0.5pt solid ; "><colgroup><col class="col_1"><col class="col_2"><col class="col_3"><col class="col_4"><col class="col_5"></colgroup><thead><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Name</td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Description</td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Size</td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Min</td><td style="border-bottom: 0.5pt solid ; ">Max</td></tr></thead><tbody><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Byte</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Signed integer</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>1 byte</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>–127</p></td><td style="border-bottom: 0.5pt solid ; "><p>128</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Short</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Signed integer</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>2 bytes</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>–32768</p></td><td style="border-bottom: 0.5pt solid ; "><p>32767</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Int</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Signed integer</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>4 bytes</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>–2<sup>31</sup></p></td><td style="border-bottom: 0.5pt solid ; "><p>2<sup>31</sup>–1</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Long</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Signed integer</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>8 bytes</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>–2<sup>63</sup></p></td><td style="border-bottom: 0.5pt solid ; "><p>2<sup>63</sup>–1</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Float</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Signed floating point</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>4 bytes</p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>n/a</p></td><td style="border-bottom: 0.5pt solid ; "><p>n/a</p></td></tr><tr><td style="border-right: 0.5pt solid ; "><p>Double</p></td><td style="border-right: 0.5pt solid ; "><p>Signed floating point</p></td><td style="border-right: 0.5pt solid ; "><p>8 bytes</p></td><td style="border-right: 0.5pt solid ; "><p>n/a</p></td><td><p>n/a</p></td></tr></tbody></table>

down conversion

```scala
val l: Long = 20
l: Long = 20

val i: Int = l.toInt
i: Int = 20
```

<table style="border-collapse: collapse; border-top: 0.5pt solid ; border-bottom: 0.5pt solid ; border-left: 0.5pt solid ; border-right: 0.5pt solid ; "><colgroup><col class="col_1"><col class="col_2"><col class="col_3"></colgroup><thead><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Literal</td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; ">Type</td><td style="border-bottom: 0.5pt solid ; ">Description</td></tr></thead><tbody><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p><code class="literal">5</code></p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Int</p></td><td style="border-bottom: 0.5pt solid ; "><p>Unadorned integer literals are <code class="literal">Int</code> by default</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p><code class="literal">0x0f</code></p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Int</p></td><td style="border-bottom: 0.5pt solid ; "><p>The “0x” prefix denotes hexadecimal notation</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p><code class="literal">5l</code></p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Long</p></td><td style="border-bottom: 0.5pt solid ; "><p>The “l” suffix denotes a <code class="literal">Long</code> type</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p><code class="literal">5.0</code></p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Double</p></td><td style="border-bottom: 0.5pt solid ; "><p>Unadorned decimal literals are <code class="literal">Double</code> by default</p></td></tr><tr><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p><code class="literal">5f</code></p></td><td style="border-right: 0.5pt solid ; border-bottom: 0.5pt solid ; "><p>Float</p></td><td style="border-bottom: 0.5pt solid ; "><p>The “f” suffix denotes a <code class="literal">Float</code> type</p></td></tr><tr><td style="border-right: 0.5pt solid ; "><p><code class="literal">5d</code></p></td><td style="border-right: 0.5pt solid ; "><p>Double</p></td><td><p>The “d suffix denotes a <code class="literal">Double</code> type</p></td></tr></tbody></table>

You can use either lowercase or uppercase letters in Scala’s literal types. The literal number `5L` is the same as the literal number `5l`.

```scala
scala> val anInt = 5
anInt: Int = 5

scala> val yellowRgb = 0xffff00
yellowRgb: Int = 16776960

scala> val id = 100l
id: Long = 100

scala> val pi = 3.1416
pi: Double = 3.1416
```

#  string interpolation

```scala
class MyClass(name: String) {            
  def sayHello(otherName: String) = 
    s"Hi $otherName, my name is $name!"  
}
```

# Exception

```scala
try {
  throw new IllegalStateException("ERROR!") 
} catch {
  case ex: RuntimeException =>   
    println("Something went bad...")
}
```