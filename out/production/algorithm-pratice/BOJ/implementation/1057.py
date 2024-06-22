# [S4] 토너먼트

import sys
input = sys.stdin.readline

N, A, B = map(int, input().split())

result = 0
while True:
    if A == B:
        break
    A = (A+1) // 2
    B = (B+1) // 2
    result += 1

print(result)