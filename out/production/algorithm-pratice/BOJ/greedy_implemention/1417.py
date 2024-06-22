# [S5] 국회의원 선거

import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
dasom = int(input())
data = [int(input()) for _ in range(N-1)]
result = 0
# 최솟값을 구하기 위해서는 최댓값만 찾아 뺴준다
data.sort(reverse=True)
if N == 1:
    pass
else:
    while dasom <= data[0]:
        dasom += 1
        data[0] -= 1
        result += 1
        data.sort(reverse=True)

print(result)
