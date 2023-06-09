# [G5] 적록색약

import sys
from collections import deque
input = sys.stdin.readline

dx = [1, -1, 0 ,0]
dy = [0, 0, 1, -1]

def bfs(y, x, color):
    que = deque()
    que.append([y, x])
    visited[y][x] = True

    while que:
        y, x = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            if color == data[ny][nx] and not visited[ny][nx]:
                que.append([ny, nx])
                visited[ny][nx] = True

    return


def bfs_blind(y, x, color):
    que = deque()
    que.append([y, x])
    visited_blind[y][x] = True

    while que:
        y, x = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        
            if nx < 0 or ny < 0 or nx >= N or ny >= N or visited_blind[ny][nx]:
                continue
            if color == 'B' and data[ny][nx] == 'B':
                que.append([ny, nx])
                visited_blind[ny][nx] = True
            elif color != 'B' and data[ny][nx] != 'B':
                que.append([ny, nx])
                visited_blind[ny][nx] = True

    return


N = int(input())
data = [list(input().rstrip()) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
visited_blind = [[False] * N for _ in range(N)]
result1 = 0
result2 =  0

# 정상
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i, j, data[i][j])
            result1 += 1

print(result1)
# 색약
for i in range(N):
    for j in range(N):
        if not visited_blind[i][j]:
            bfs_blind(i, j, data[i][j])
            result2 += 1

print(result2)