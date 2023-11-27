# Table of contents

- [Table of contents](#table-of-contents)
- [Docs](#docs)
- [Basic syntax](#basic-syntax)
  - [Code Conventions](#code-conventions)
  - [Console](#console)
  - [const let var](#const-let-var)
    - [Const](#const)
    - [let](#let)
    - [var](#var)
  - [null vs undefined](#null-vs-undefined)
  - [Comparison operators](#comparison-operators)
  - [if-else](#if-else)
- [Strings](#strings)
  - [Basic string methods](#basic-string-methods)
  - [regex with string](#regex-with-string)
  - [repeat](#repeat)
- [Arrays](#arrays)
  - [Array as a Stack](#array-as-a-stack)
  - [Concat arrays](#concat-arrays)
  - [Join array and string](#join-array-and-string)
  - [Reverse array](#reverse-array)
  - [Shift. Return and delete the first element of array](#shift-return-and-delete-the-first-element-of-array)
  - [Unshift. Add to the beginiing of array](#unshift-add-to-the-beginiing-of-array)
  - [Slice. Get sub array](#slice-get-sub-array)
  - [Sort of array](#sort-of-array)
  - [Splice. Remove items and paste value](#splice-remove-items-and-paste-value)
- [Modules](#modules)
- [Examples](#examples)
  - [Change internal in html tag](#change-internal-in-html-tag)
  - [Change css](#change-css)
  - [Change tag attribute](#change-tag-attribute)
  - [If JS disabled](#if-js-disabled)

# Docs

[docs MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

# Basic syntax

## Code Conventions

```js

// variable names
var yearMonthDay = moment().format("YYYY/MM/DD");

// constants
const FIRST_US_PRESIDENT = "George Washington"

// not a magic constant literals
const MINUTES_IN_A_YEAR = 52600;
for(let i = 0; i < MINUTES_IN_A_YEAR; i++){
    runJob();
}

// not use unneeded context
var Car = {
    carMake: "Honda",
    carModel: "Accord",
    carColor: "Blue"
} // car is redundunt in this case



```

##  Console

to print something for debug
```js
console.log('hello world')
```

## const let var

### Const

For constants. Final variable

```js
const Pi = 3.14

Pi = 4  // ERROR
```

### let

for block level variables

```js

console.log(i)     // ERROR 

for(let i = 0; i< 3, i++){
    console.log(i)     // 1 2 
}

console.log(i)     // ERROR 

```

### var 

For global variables

```js

console.log(i)     // undefined. Compiler knows that this variable exists.

for(var i = 0; i< 3, i++){
    console.log(i)     // 1 2 
}

console.log(i)     // 3 

```

## null vs undefined

```js

var test
console.log(test) // undefined

test = null
console.log(test) // null

console.log(typeof null) // Object
console.log(typeof undefined) // undefined


console.log(null === undefined) // false
console.log(null == undefined) // true
console.log(null === null) // true
console.log(null == null) // true


console.log(!null) // true
console.log(!!null) // false

console.log(1 + null) // 1
console.log(1 + undefined) // NaN
```


## Comparison operators

as usual 

`>` `<` `<=` `>=` `!=` `==`


## if-else

```js
var hello = true;

if(hello){
    console.log("Hello World");
} else{
    console.log("Bye");
}
```

```js
var age = 18;

if(age >= 18){
    console.log("You are an adult");
} else if (age < 2) {
    console.log("You are a baby");
} else if (age < 18) {
    console.log("You are a child");
}

if(age == 18){
    console.log("You are eighteen");
}


if(age != 18){
    console.log("You are NOT eighteen");
}

```

# Strings

## Basic string methods

```js
var first = "hello"
first.charAt(1) // e
```

```js
var second = "world"
// return Unicode code
second.charCodeAt(2) // 114
```


```js
String.fromCharCode(114) // r
```

```js
var first = "hello"
var second = "world"
first.concat(second) // helloworld
```

```js
var first = "hello"
first.endWith("lo") // true
```

```js
var first = "hello"
first.startWith("he") // true
```

```js
var first = "hello"
first.includes("ell") // true
```


```js
var first = "hello"
first.indexOf("l") // 2
```

```js
var first = "hello end world end"
first.lastIndexOf("end") // 16
```

```js
var first = "hello"
first.slice(2, 4) // ll
```

```js
var first = "hello"
first.substr(3, 2) // lo 
```

```js
var first = "hello"
first.subsstring(2, 4) // ll
```


```js
var first = "hello world"
first.split(" ") // ["hello", "world"]
```

```js
var first = "HEllo"
first.toLowerCase(first) // hello
```

```js
var first = "hello"
first.toUpperCase(first) // HELLO
```

```js
var first = "   hello  "
first.trim(first) // "hello"
```

## regex with string

```js
var first = "hello end world end"
first.match("/end/g") // ["end", "end"]
```

```js
var first = "hello end world end"
first.replace("/end/g", "END") // "hello END world END"
```

```js
var first = "hello end world end"
first.search("end") // 6 
```


## repeat

```js
var first = "k"
first.repeat(3) // kkk
```


# Arrays

## Array as a Stack

Mutable operations

```js
var arr = ["a", "b", "c"]

arr.push("d")
console.log(arr) // ["a", "b", "c", "d"]

console.log(arr.pop())   // "d"
console.log(arr) // ["a", "b", "c"]
```

## Concat arrays

``` js
var arr2 = ["g", "q"]
console.log(arr.concat(arr2)) // ["a", "b", "c", "g",  "q" ]

console.log(arr2) // ["g",  "q" ]
```

## Join array and string

```js
var arr = ["a", "b", "c"]
console..log(arr.join("")) // abc
console..log(arr.join("!")) // a!b!c!
```

## Reverse array

Mutable operation

```js
var arr = ["a", "b", "c"]
console..log(arr.reverse()) // ["c", "b", "a"]

console..log(arr) // ["c", "b", "a"]
```

## Shift. Return and delete the first element of array


Mutable operation

```js
var arr = ["a", "b", "c"]
console..log(arr.shift()) // a

console..log(arr) // ["b", "c"]
```

## Unshift. Add to the beginiing of array

Mutable operation
```js
var arr = ["a", "b", "c"]
console..log(arr.unshift("e")) // 4

console..log(arr) // ["e", "a", "b", "c"]
```

## Slice. Get sub array

```js
var arr = ["a", "b", "c"]
console..log(arr.slice(1, 2)) // ["b"]
```

## Sort of array

Mutable operation

```js
var arr = ["c", "b", "a"]
console..log(arr.sort()) // ["a", "b", "c"]
```

## Splice. Remove items and paste value

```js
var arr = ["a", "b", "c", "d", "e"]
console..log(arr.splice(2, 2, "JS")) // ["c", "d"]
console..log(arr) // ["a", "b", "JS", "e"]
```

# Modules

```js
// After ES6

// libs/module.js

class ShoppingDataType{
    constructor(){
        // private properties
        this.shoppingList = ["coffee", "chicken", "pizza"]
    }

// public methods
    getShoppingList(){
        return this.shoppingList.join(", ")
    }

    addItem(item){
        this.shoppingList.push(item)
    }
}

export default ShoppingDataType;

// main.js

import ShoppingDataType from 'libs/module';

var shopping = new ShoppingDataType;
console.log(shopping.getShoppingList());

```


# Examples


## Change internal in html tag

```html
<html>
    <body>
        <h1>My First JavaScript</h1>
        <p>JavaScript can change the content of an HTML element:</p>
        <button type="button" onclick="myFunction()">Click Me!</button>
        <p id="demo">This is a demonstration.</p>
        <script>
            function myFunction() {
                document.getElementById("demo").innerHTML = "Hello JavaScript!";
            }
        </script>
    </body>
</html>
```

## Change css

```html
<!DOCTYPE html>
<html>
    <body>
        <h1>My First JavaScript</h1>
        <p id="demo">JavaScript can change the style of an HTML element.</p>
        <script>
            function myFunction() {
                document.getElementById("demo").style.fontSize = "25px";
                document.getElementById("demo").style.color = "red";
                document.getElementById("demo").style.backgroundColor = "yellow";        
            }
        </script>
        <button type="button" onclick="myFunction()">Click Me!</button>
    </body>
</html>
```

## Change tag attribute 

```html
<!DOCTYPE html>
<html>
    <body>
    <script>    
        function light(sw) {
            var pic;
            if (sw == 0) {
                pic = "pic_bulboff.gif"
            } else {
                pic = "pic_bulbon.gif"
            }
            document.getElementById('myImage').src = pic;
        }
    </script>

    <img id="myImage" src="pic_bulboff.gif" width="100" height="180">
    <p>
        <button type="button" onclick="light(1)">Light On</button>
        <button type="button" onclick="light(0)">Light Off</button>
    </p>
    </body>
</html>
```

## If JS disabled

```html
<script>
document.getElementById("demo").innerHTML = "Hello JavaScript!";
</script>

<noscript>Sorry, your browser does not support JavaScript!</noscript> -->
```