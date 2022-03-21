# 미로 찾기
from collections import deque
n, m = map(int, input().split())
data = [list(map(int, input())) for _ in range(n)]
que = deque()
que.append([0, 0])
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
while que:
    x, y = que.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if data[nx][ny] == 0:
            continue
        if data[nx][ny] == 1:
            data[nx][ny] = data[x][y] + 1
            que.append([nx, ny])
print(data[n-1][m-1])