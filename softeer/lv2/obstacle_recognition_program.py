# 장애물 인식 프로그램

import sys
from collections import deque

# test 2

input = sys.stdin.readline

N = int(input())
data = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dy = [0, 1, 0, 1]
dx = [1, 0, -1, 0]
move_list = []

def bfs(y, x):
    move = 1
    que = deque([[y, x]])
    visited[y][x] = True

    while que:
        y, x = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if data[ny][nx] == 0:
                continue
            if data[ny][nx] == 1 and not visited[ny][nx]:
                move += 1
                visited[ny][nx] = True
                que.append([ny, nx])
    
    return move

for i in range(N):
    for j in range(N):
        if data[i][j] == 1 and not visited[i][j]:
            move_list.append(bfs(i, j))

move_list.sort()
print(len(move_list))
for m in move_list:
    print(m)

# test 1
# def bfs(start):
#     cnt = 1
#     que = deque([[start[0], start[1]]])

#     dx = [-1, 1, 0, 0]
#     dy = [0, 0, -1, 1]

#     while que:
#         y, x = que.popleft()
#         data[y][x] = 0

#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]

#             if nx < 0 or ny < 0 or nx >= N or ny >= N:
#                 continue
#             if data[ny][nx] == 1:
#                 data[ny][nx] = 0
#                 cnt += 1
#                 que.append([ny, nx])

#     return cnt

# input = sys.stdin.readline
# N = int(input())
# data = []
# result = []

# for _ in range(N):
#     col = input().strip()
#     temp = []
#     for i in range(len(col)):
#         temp.append(int(col[i]))
#     data.append(temp)

# for i in range(N):
#     for j in range(N):
#         if data[i][j] == 1:
#             result.append(bfs([i, j]))

# result.sort()
# print(len(result))
# for i in range(len(result)):
#     print(result[i])