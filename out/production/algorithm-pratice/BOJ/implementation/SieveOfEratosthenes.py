# [S4] 에라토스테네스의 체

import sys
input = sys.stdin.readline

N, K = map(int, input().split())

data = [i for i in range(N+1)]
count = 0

for i in range(2, len(data)):
    if data[i] == 0:
        continue
    for j in range(i, len(data), i):
        if data[j] != 0:
            count += 1
        if count == K:
            print(data[j])
            break
        data[j] = 0
