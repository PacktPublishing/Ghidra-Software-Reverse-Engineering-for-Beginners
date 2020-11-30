from z3 import *

x = Int('x')
y = Int('y')

s = Solver()

s.add(y == x + 5)
s.add(y>x)

print(s.check())