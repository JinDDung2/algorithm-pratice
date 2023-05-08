# 나이트의 이동
from collections import deque

def bfs(x1, y1, x2, y2):
    que = deque()
    que.append([y1, x1])

    dx = [-2, -1, 1, 2, -2, -1, 1, 2]
    dy = [-1, -2, -2, -1, 1, 2, 2, 1]
    while que:
        y, x = que.popleft()
        if y == y2 and x == x2:
            break

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= I or ny >= I:
                continue
            if data[ny][nx] == 0:
                data[ny][nx] = data[y][x] + 1
                que.append([ny, nx])

    return data[y2][x2]


N = int(input())

for i in range(N):
    I = int(input())
    data = [[0] * I for _ in range(I)]
    x1, y1 = map(int, input().split())
    x2, y2 = map(int, input().split())
    print(bfs(x1, y1, x2, y2))

# def night(x1, y1, x2, y2):
#     dx = [-1, -2, -2, -1, 1, 2, 2, 1]
#     dy = [-2, -1, 1, 2, 2, 1, -1, -2]
#     que = deque()
#     que.append([x1, y1])
#     while que:
#         x, y = que.popleft()
#         if x == x2 and y == y2:
#             move = chess[x][y]
#             break
#         for i in range(8):
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0 <= nx < l and 0 <= ny < l:
#                 if chess[nx][ny] == 0:
#                     que.append([nx, ny])
#                     chess[nx][ny] = chess[x][y] + 1

#     return move


# test = int(input())
# lst = []

# for _ in range(test):
#     l = int(input())
#     x1, y1 = map(int, input().split()) 
#     x2, y2 = map(int, input().split()) 
#     chess = [[0]*l for _ in range(l)]
#     lst.append(night(x1, y1, x2, y2))
    
# for i in lst:
#     print(i)