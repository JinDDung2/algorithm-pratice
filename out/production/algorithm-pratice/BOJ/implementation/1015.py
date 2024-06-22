# [S4] 수얼 정렬

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
lst = sorted(data)

result = []

for i in range(N):
    idx = lst.index(data[i])
    result.append(idx)
    lst[idx] = -1

print(*result)