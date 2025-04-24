class Parent:
    def greet(self):
        print("Hello from the parent class")

class Child(Parent):
    def greet_child(self):
        print("Hello from the child class")

c = Child()
c.greet()        # Inherited from Parent
c.greet_child()  # Defined in Child