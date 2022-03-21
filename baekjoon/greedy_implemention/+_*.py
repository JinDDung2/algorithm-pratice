import sys


s = sys.stdin.readline().strip()
result = int(s[0])
for i in range(1, len(s)):
    if int(s[i]) <= 1 or result <= 1:
        # print('01', s[i])
        result += int(s[i])
    else:
        # print('02', s[i])
        result *= int(s[i])

print(result)