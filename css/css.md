
# Table of contents

- [Table of contents](#table-of-contents)
- [Color and alignment](#color-and-alignment)
  - [Change page color](#change-page-color)
  - [Change text color](#change-text-color)
  - [Change font](#change-font)
  - [Change font size](#change-font-size)
  - [Change alignment](#change-alignment)
  - [Border](#border)
  - [Padding. Distance between text and border](#padding-distance-between-text-and-border)
  - [Margin Distance between border and other elements](#margin-distance-between-border-and-other-elements)
- [Selectors](#selectors)
  - [Change certain element](#change-certain-element)
  - [Change all elements of the class](#change-all-elements-of-the-class)
  - [Pseudo-classes. Example change link view](#pseudo-classes-example-change-link-view)
- [Image styling](#image-styling)
- [Tables](#tables)
  - [Change table border](#change-table-border)
  - [Table padding. Between text and border inside](#table-padding-between-text-and-border-inside)
  - [Header to the left](#header-to-the-left)
  - [Space between cells](#space-between-cells)
  - [Alternation](#alternation)
- [Colors](#colors)
- [Encoding](#encoding)

# Color and alignment

## Change page color

```html
<body style="background-color:powderblue;">

    <h1>This is a heading</h1>
    <p>This is a paragraph.</p>
</body>
```

## Change text color
```html
<p style="color:red;">This is a paragraph.</p>
```

## Change font

```html
<h1 style="font-family:verdana;">This is a heading</h1>
```

## Change font size

```html
<h1 style="font-size:300%;">This is a heading</h1>
```

## Change alignment

```html
<h1 style="text-align:center;">Centered Heading</h1>
```

## Border

Every `<p>` with border
```css
p {
    border: 1px solid powderblue;   /*  Amount of pixels, type, and color */
}
```

## Padding. Distance between text and border

```css
p {
    border: 1px solid powderblue;
    padding: 30px;
}
```

## Margin Distance between border and other elements

```css
p {
    border: 1px solid powderblue;
    margin: 50px;
}
```

# Selectors

## Change certain element

```html
<p id="p01">I am different</p>
```

```css
#p01 {
    color: blue;
}
```

## Change all elements of the class

```html
<!DOCTYPE html>
<html>
    <head>
    <style>
        p.error {
            color: red;
        }
    </style>
    </head>
    <body>
        <p>This is a paragraph.</p>
        <p>This is a paragraph.</p>
        <p class="error">I am different.</p>
        <p>This is a paragraph.</p>
        <p class="error">I am different too.</p>
    </body>
</html>
```

## Pseudo-classes. Example change link view

```css
a:link {
    color: green;
    background-color: transparent;
    text-decoration: none;
}

a:visited {
    color: pink;
    background-color: transparent;
    text-decoration: none;
}

a:hover {
    color: red;
    background-color: transparent;
    text-decoration: underline;
}

a:active {
    color: yellow;
    background-color: transparent;
    text-decoration: underline;
}
```

# Image styling

```html
<p> 
    <img src="smiley.gif" alt="Smiley face" style="float:right;width:42px;height:42px;">
    The image will float to the right of the text.
</p>
```

```html
<p>
    <img src="smiley.gif" alt="Smiley face" style="float:left;width:42px;height:42px;">
    The image will float to the left of the text.
</p>
```

# Tables

## Change table border

```css
table, th, td {
    border: 1px solid black;
}
```

collapse border

```css
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
```

## Table padding. Between text and border inside

```css
th, td {
    padding: 15px;
}
```

## Header to the left

By default : center

```css
th {
    text-align: left;
}
```

## Space between cells

```css
table {
        border-spacing: 5px;
}
```

## Alternation


```css
table#t01 tr:nth-child(even) {
    background-color: #eee;
}

table#t01 tr:nth-child(odd) {
    background-color: #fff;
}

table#t01 th {  /* header */
    color: white;
    background-color: black;
}
```

# Colors

[Colors constants](https://www.w3schools.com/colors/colors_names.asp)

Gray colors when all numbers are the same
```
rgb(0,0,0)   
rgb(90,90,90)   
rgb(128,128,128)   
rgb(200,200,200)   
rgb(255,255,255)
```

# Encoding

**ASCII** was the first character encoding standard (also called character set). 

**ASCII** defined 127 different alphanumeric characters that could be used on the internet: numbers (0-9), English letters (A-Z), and some special characters like ! $ + - ( ) @ < > .

**ANSI (Windows-1252)** was the original Windows character set, with support for 256 different character codes.

**ISO-8859-1** was the default character set for HTML 4. This character set also supported 256 different character codes.

Because **ANSI** and **ISO-8859-1** were so limited, the default character encoding was changed to **UTF-8** in HTML5.

**UTF-8 (Unicode)** covers almost all of the characters and symbols in the world.

All HTML 4 processors also support UTF-8 encoding.

For HTML4:
```html
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
```

For HTML5:
```html
<meta charset="UTF-8">
```