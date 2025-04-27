class Parent:
    def greet(self):
        print("hello from parent")

class Child(Parent):
    def greet_child(self):
        print("hello from child")

c = Child()
c.greet()
c.greet_child()
