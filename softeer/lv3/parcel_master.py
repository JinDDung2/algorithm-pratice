# 택배 마스터 광우

import sys
input = sys.stdin.readline
from itertools import permutations

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
