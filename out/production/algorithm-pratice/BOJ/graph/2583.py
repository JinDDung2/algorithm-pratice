# 영역 구하기
import sys
from collections import deque

input = sys.stdin.readline

# m=세로, n=가로
n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]
sizes = []

for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for a in range(y1, y2):
        for b in range(x1, x2):
            graph[a][b] = 1

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            size = 1
            graph[i][j] = 1
            que = deque([i, j])
            while que:
                x, y = que.popleft(), que.popleft()
                for k in range(4):
                    # print(f"typeX={type(x)}, typeDX={type(dx[k])}")
                    nx = dx[k] + x
                    ny = dy[k] + y
                    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                        graph[nx][ny] = 1
                        size += 1
                        que.append(nx)
                        que.append(ny) 

            sizes.append(size)

print(len(sizes))
sizes.sort()
for sqare in sizes:
    print(sqare, end=' ')