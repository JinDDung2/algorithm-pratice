# 멋쟁이 토마토~ 토마토!!
from collections import deque

def bfs(tomato_list):
    day = -1
    que = deque(tomato_list)
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while que:
        for i in range(len(que)):
            y, x = que.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or ny < 0 or nx >= N or ny >= M:
                    continue
                if data[ny][nx] == 0:
                    data[ny][nx] = 1
                    que.append([ny, nx])

        day += 1

    count = 0
    for d in data:
        count += sum(d)

    if ( (N * M) - (wall* 2) ) == count:
        return day
    else:
        return -1


N, M = map(int, input().split()) # N = 가로, M = 세로
data = []
for _ in range(M):
    data.append(list(map(int, input().split())))
tomato_list = []
wall = 0

for i in range(M):
    for j in range(N):
        if data[i][j] == 1:
            tomato_list.append([i, j])
        elif data[i][j] == -1:
            wall += 1

print(bfs(tomato_list))

# def bfs():
#     global day
#     dx = [-1, 1, 0, 0]
#     dy = [0, 0, -1, 1]
#     box = deque()
#     for i in start:
#         box.append(i)
#     while box:
#         day += 1
#         for _ in range(len(box)):
#             x, y = box.popleft()
#             for i in range(4):
#                 nx = x + dx[i]
#                 ny = y + dy[i]
#                 if 0 <= nx < n and 0 <= ny < m:
#                     if data[nx][ny] == 0:
#                         # if [nx, ny] not in box:
#                         box.append([nx, ny])
#                         data[nx][ny] = 1


# m, n = map(int, input().split()) # m 가로 / n 세로
# # data = [list(map(int, input().split())) for _ in range(n)]
# data = []
# start = []
# day = 0

# for i in range(n):
#     data.append(list(map(int, input().split())))
#     for j in range(m):
#         if data[i][j] == 1:
#             start.append([i, j])
#         if data[i][j] == -1:
#             data[i][j] = 1

# day = 0
# bfs()

# for i in data:
#     for j in i:
#         if j == 0:
#             print(-1)
#             exit()
# print(day-1)