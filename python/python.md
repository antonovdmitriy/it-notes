
- [Inheritance](#inheritance)
  - [Syntax](#syntax)
  - [Example usage](#example-usage)
  - [Overriding methods](#overriding-methods)
  - [Using `super()`](#using-super)
- [Strings](#strings)
- [F-strings](#f-strings)
- [Methods](#methods)


## Inheritance

### Syntax

```python
class Parent:
    def greet(self):
        print("Hello from the parent class")

class Child(Parent):
    def greet_child(self):
        print("Hello from the child class")
```

### Example usage

```python
c = Child()
c.greet()        # Inherited from Parent
c.greet_child()  # Defined in Child
```

### Overriding methods

Child classes can override methods from the parent:

```python
class Child(Parent):
    def greet(self):
        print("Hello from the child (overridden)")
```

### Using `super()`

You can call methods from the parent class using `super()`:

```python
class Child(Parent):
    def greet(self):
        super().greet()
        print("...and hello from the child")
```


## Strings

- It possible to write string literals with single or double quates
- You don't need to write a type

Concatination
```python
first_name = "Ivan"
second_name = "Sidorov"
full_name = f"{first_name} {second_name}"
print(full_name)
```

## F-strings

F-string starts from the 3.6 version.

You can invoke methods on f strings
```python
first_name = "Ivan"
second_name = "Sidorov"
full_name = f"{first_name} {second_name}"
print(full_name)
print(f"Hello {full_name.upper()}!")
```

assign f-string to variable
```python
first_name = "Ivan"
second_name = "Sidorov"
full_name = f"{first_name} {second_name}"
print(full_name)
greetings = f"Hello {full_name.upper()}!"
print(greetings)
```

before 3.6
```python
greetings = "Hello {}!".format(full_name)
print(greetings)
```

## Methods

Example how to invoke a method

```python
name = "my_name"
print(name.upper())
print(name.lower())
```
