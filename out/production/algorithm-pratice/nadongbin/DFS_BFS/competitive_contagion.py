# 경쟁적 전염

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
data = [(list(map(int, input().split()))) for _ in range(N)]
S, X, Y = map(int, input().split())

que = deque()
virus = []
for i in range(N):
    for j in range(N):
        if data[i][j] != 0:
            virus.append([i, j, data[i][j]])


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
time = 0
virus.sort(key= lambda x:x[-1])
for v in virus:
    que.append(v)
temp = []
print(que)
while time != S:
    while que:
        y, x, power = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if data[ny][nx] == 0 or data[ny][nx] > data[y][x]:
                data[ny][nx] = data[y][x]
                temp.append([ny, nx, data[ny][nx]])
    temp.sort(key= lambda x:x[-1])
    for t in temp:
        que.append(t)
    time += 1

print(data[X-1][Y-1])
# print(data)

# test 1 -> 3
# 3 3
# 1 0 2
# 0 0 0
# 3 0 0
# 2 3 2

# test 2 -> 0
# 3 3
# 1 0 2
# 0 0 0
# 3 0 0
# 1 2 2