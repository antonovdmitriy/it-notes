## Table of contents

- [Methods](#methods)


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
