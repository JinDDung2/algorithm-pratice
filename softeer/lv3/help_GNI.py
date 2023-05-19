# GNI야 도와줘

import sys
from collections import deque
input = sys.stdin.readline

def raining():
    global rains
    temp = []

    for y, x in rains:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= C or ny >= R:
                continue
            if data[ny][nx] == '.':
                data[ny][nx] = "*"
                temp.append((ny, nx))

    rains = list(set(rains + temp))


def bfs(start):
    que = deque()
    y, x = start[0], start[1]
    # [행, 열, 이동횟수]
    que.append([y, x, 0])
    p_visited[y][x] = True
    temp = 0
    raining()
    
    while que:
        y, x, cnt = que.popleft()

        if temp < cnt:
            raining()
        
        temp = cnt
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= C or ny >= R:
                continue
            if ny == end[0] and nx == end[1]:
                return cnt + 1
            if data[ny][nx] == '.' and not p_visited[ny][nx]:
                p_visited[ny][nx] = True
                que.append([ny, nx, cnt+1])
    
    return "FAIL"

R, C = map(int, input().split())
data = [list(input().rstrip()) for _ in range(R)]
p_visited = [[False] * C for _ in range(R)]
rains = []

for i in range(R):
    for j in range(C):
        if data[i][j] == 'H':
            start = [i, j]
        elif data[i][j] == 'W':
            end = [i, j]
        elif data[i][j] == '*':
            rains.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

print(bfs(start))