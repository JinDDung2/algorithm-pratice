# [S1] 구간 합 구하기 5

import sys
input = sys.stdin.readline

N,M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
aSum = [[0] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1):
        aSum[i][j] = data[i-1][j-1] + (aSum[i-1][j] + aSum[i][j-1] - aSum[i-1][j-1])

# print(aSum)

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(aSum[x2][y2] - aSum[x2][y1-1] - aSum[x1-1][y2] + aSum[x1-1][y1-1])
