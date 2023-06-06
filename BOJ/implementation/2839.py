# [S4] 설탕배달

import sys
input = sys.stdin.readline

n = int(input())
result = 0

while n >= 0:
    if n % 5 == 0:
        result += (n // 5)
        print(result)
        break
    n -= 3
    result += 1

if n < 0:
    print(-1)