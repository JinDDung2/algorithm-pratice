# [G5] 치킨 배달

import sys
from itertools import permutations
input = sys.stdin.readline

N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]

ck = []
house = []

for i in range (N):
    for j in range(N):
        if data[i][j] == 1:
            house.append((i, j))
        elif data[i][j] == 2:
            ck.append((i, j))

result = sys.maxsize
# 치킨집 총 수가 최대 치킨집이랑 같을 경우
if len(ck) == M:
    temp_result = 0
    for h in house:
        temp = sys.maxsize
        y1, x1 = h[0], h[1]
        for c in ck:
            y2, x2 = c[0], c[1]
            temp = min(temp, abs(y1-y2) + abs(x1-x2))
        temp_result += temp
    result = min(result, temp_result)
else:
# ck길이 중 M개 선택
    for da in permutations(ck, M):
        temp_result = 0
        for h in house:
            temp = sys.maxsize
            y1, x1 = h[0], h[1]
            for d in da:
                y2, x2 = d[0], d[1]
                temp = min(temp, abs(y1-y2) + abs(x1-x2))
            temp_result += temp
        # 각 집에서 치킨까지의 거리의 최솟값을 모아두고 그중 최댓값을 비교 -> 이 중에서 최솟값
        result = min(result, temp_result)

print(result)