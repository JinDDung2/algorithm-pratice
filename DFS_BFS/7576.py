# 멋쟁이 토마토~ 토마토!!
from collections import deque
m, n = map(int, input().split()) # m 가로 / n 세로
data = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
start = []
for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            start.append([i, j])
        if data[i][j] == -1:
            data[i][j] = 1
day = 0
def bfs():
    global day
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    box = deque()
    for i in start:
        box.append(i)
    while box:
        day += 1
        for _ in range(len(box)):
            x, y = box.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < n and 0 <= ny < m:
                    if data[nx][ny] == 0:
                        if [nx, ny] not in box:
                            box.append([nx, ny])
                            data[nx][ny] = 1
bfs()
for i in data:
    for j in i:
        if j == 0:
            print(-1)
            exit()
print(day-1)