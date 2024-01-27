import math
class CircleComp:
    def __init__(self, radius):
        self.radius = radius
        self.diameter = 0
        self.circumference = 0
        self.area = 0

    def calculate_properties(self):
        self.diameter = self.radius * 2.0

        self.circumference = 2 * math.pi * self.radius

        self.area = math.pi * self.radius * self.diameter

    def display_properties(self):
        self.print = print(f"Diameter: {self.diameter}")
        print(f"Circumference: {self.circumference}")
        print(f"Area: {self.area}")


radius = float(input("Enter the radius of the circle: "))
circle = CircleComp(radius)
circle.calculate_properties()
circle.display_properties()