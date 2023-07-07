# [S5] 사과 담기 게임

import sys
input = sys.stdin.readline
N, M = map(int, input().split())
j = int(input())
data = [int(input()) for _ in range(j)]
# leftside, rightside 알아두기
# M = 1 이면 그냥 left로만
# 현재위치 > 사과 떨어질 위치 -> leftside - 사과위치
# 현재위치 < 사과 떨어질 위치 -> 사과 위치- rightside
# leftside <= 사과 떨어질 위치 <= rightside -> 그대로
count = 0
left = 1
right = left+(M-1)

for i in range(len(data)):
    if left <= data[i] <= right:
        continue
    if data[i] > right:
        count += data[i] - right
        right = data[i]
        left = right - (M-1)
    if data[i] < left:
        count += left - data[i]
        left = data[i]
        right = left + (M-1)

print(count)