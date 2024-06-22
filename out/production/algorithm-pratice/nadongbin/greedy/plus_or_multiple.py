# 더하기 혹은 곱하기

import sys
input = sys.stdin.readline

N = input().rstrip()
data = []

for num in N:
    if num != '0':
        data.append(int(num))

if data[0] == 1:
    result = 0
else:
    result = 1

for d in data:
    if d == 1:
        result += d
    else:
        result *= d

print(result)


'''
n = input()
data = [int(num) for num in n]
data.sort(reverse=True)
result = 1

if data[0] == 0:
    result = 0

for num in data:
    if num == 0:
        continue
    if num == 1:
        result += num
    else:
        result *= num

print(result)
'''
# 02984