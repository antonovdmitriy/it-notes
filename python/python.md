
- [Inheritance](#inheritance)
  - [Syntax](#syntax)
  - [Example usage](#example-usage)
  - [Overriding methods](#overriding-methods)
  - [Using `super()`](#using-super)
- [Strings](#strings)
- [F-strings](#f-strings)
- [Methods](#methods)
- [QuickstartUser](#quickstartuser)
  - [QuickstartUser](#quickstartuser-1)


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


## QuickstartUser

### QuickstartUser

`QuickstartUser` is a custom class that inherits from `HttpUser` in **Locust**. It defines the behavior of a simulated user for load testing a web application. Inside the class, you define tasks (actions the user will perform) and optionally set a wait time between tasks.

Example:

```python
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 5)  # wait between 1 and 5 seconds between tasks

    @task
    def load_homepage(self):
        self.client.get("/")  # simulate GET request to homepage

    @task
    def load_about_page(self):
        self.client.get("/about")  # simulate GET request to /about
```

This class simulates a user that:
- Waits between 1 and 5 seconds between tasks
- Repeatedly visits the homepage (`/`) and the about page (`/about`) of a website

