# [21년 재직자 대회 예선] 이미지 프로세싱

import sys
from collections import deque

def bfs(lst):
    que = deque()
    que.append(lst)
    oldColor = data[lst[0]][lst[1]]
    visited = [[False] * (W+1) for _ in range(H+1)]
    visited[lst[0]][lst[1]] = True
    

    while que:
        y, x, newColor = que.popleft()
        data[y][x] = newColor

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 1 or ny < 1 or nx > W or ny > H or visited[ny][nx]:
                continue
            
            if data[ny][nx] == oldColor:
                data[ny][nx] = newColor
                visited[ny][nx] = True
                que.append([ny, nx, newColor])


input = sys.stdin.readline
H, W = map(int, input().split())
data = [[0] * (W+1)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(H):
    data.append([0] + list(map(int, input().split())))
Q = int(input())
o = []
for _ in range(Q):
    o.append(list(map(int, input().split())))

for l in o:
    bfs(l)

for i in range(1, len(data)):
    for j in range(1, len(data[i])):
        print(data[i][j], end=' ')
    print()