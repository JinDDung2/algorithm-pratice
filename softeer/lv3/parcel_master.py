# 택배 마스터 광우

import sys
from itertools import permutations
input = sys.stdin.readline

N, M, K = map(int, input().split())
data = list(map(int, input().split()))
result = sys.maxsize

for p in permutations(data, N):
    workCount = 0
    bucket = 0
    idx = 0
    tempWeight = 0
    while workCount < K:
        if bucket + p[idx % N] <= M:
            bucket += p[idx % N]
            idx += 1
        else:
            workCount += 1
            tempWeight += bucket
            bucket = 0
    result = min(result, tempWeight)

print(result)

'''test 1
N, M, K = map(int, input().split())
weights = list(map(int, input().split()))

weights_info = permutations(weights, N)
result = sys.maxsize

for info in weights_info:
    info = list(info)

    idx = 0
    bucket = 0
    work = 0
    temp_weight = 0

    while work < K:
        if bucket + info[idx] <= M:
            bucket += info[idx]
            info.append(info[idx])
            idx += 1
        else:
            temp_weight += bucket
            bucket = 0
            work += 1

    result = min(result, temp_weight)

print(result)
'''