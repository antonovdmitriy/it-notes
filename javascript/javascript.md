# Table of contents

- [Table of contents](#table-of-contents)
- [Docs](#docs)
- [Console](#console)
- [const let var](#const-let-var)
  - [Const](#const)
  - [let](#let)
  - [var](#var)
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

# Console

to print something for debug
```js
console.log('hello world')
```

# const let var

## Const

For constants. Final variable

```js
const Pi = 3.14

Pi = 4  // ERROR
```

## let

for block level variables

```js

console.log(i)     // ERROR 

for(let i = 0; i< 3, i++){
    console.log(i)     // 1 2 
}

console.log(i)     // ERROR 

```

## var 

For global variables

```js

console.log(i)     // undefined. Compiler knows that this variable exists.

for(var i = 0; i< 3, i++){
    console.log(i)     // 1 2 
}

console.log(i)     // 3 

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