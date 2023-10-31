# Table of contents

- [Table of contents](#table-of-contents)
- [Docs](#docs)
- [Tricks](#tricks)
  - [Console](#console)
- [Examples](#examples)
  - [Change internal in html tag](#change-internal-in-html-tag)
  - [Change css](#change-css)
  - [Change tag attribute](#change-tag-attribute)
  - [If JS disabled](#if-js-disabled)

# Docs

[docs MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

# Tricks

## Console

to print something for debug
```js
console.log('hello world')
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