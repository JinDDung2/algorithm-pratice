# [S3] 소수구하기

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = [i for i in range(1000001)]
data[1] = 0

for i in range(2, len(data)):
    if data[i] == 0:
        continue
    for j in range(i+i, len(data), i):
        data[j] = 0

for i in range(N, M+1):
    if data[i]:
        print(data[i])