# 3차원 토마토
from collections import deque


m, n, h = map(int, input().split())
data = [[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]

start = []
day = 0

for k in range(h):
    for i in range(n):
        for j in range(m):
            if data[k][i][j] == 1:
                start.append([k, i, j])


def bfs():
    global day
    dx = [-1, 1, 0, 0,0,0]
    dy = [0, 0, -1, 1,0,0]
    dz = [0, 0, 0, 0, 1, -1]
    box = deque()
    for i in start:
        box.append(i)
    while box:
        day += 1
        for _ in range(len(box)):
            z, x, y = box.popleft()
            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]
                if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h:
                    if data[nz][nx][ny] == 0:
                        data[nz][nx][ny] = 1
                        box.append([nz, nx, ny])
            
            
bfs()

for k in range(h):
    for i in range(n):
        for j in range(m): 
            if data[k][i][j] == 0:
                print(-1)
                exit()

print(day-1)