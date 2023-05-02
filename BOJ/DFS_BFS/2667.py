# 단지번호붙이기
from collections import deque

n = int(input())
data = [list(map(int, input())) for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(data, start):
    global cnt
    que = deque()
    que.append([start[0], start[1]])
    data[start[0]][start[1]] = 0
    cnt = 1

    while que:
        x, y = que.popleft()
        data[x][y] = 0
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if data[nx][ny] == 1:
                data[nx][ny] = 0
                que.append([nx, ny])
                cnt += 1
    
    return cnt

cnt_list = []
for i in range(n):
    for j in range(n):
        if data[i][j] == 1:
            cnt_list.append(bfs(data, [i, j]))

# 총 단지 수
cnt_list.sort()
print(len(cnt_list))
# 각 단지마다 수
for i in range(len(cnt_list)):
    print(cnt_list[i])

# def dfs(x, y):
#     global cnt
#     visited[x][y] = True
#     if data[x][y] == 1:
#         cnt += 1
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if nx < 0 or ny < 0 or nx >= n or ny >= n:
#             continue
#         if 0 <= nx < n and 0 <= ny < n:
#             if visited[nx][ny] == False and data[nx][ny] == 1:
#                 dfs(nx, ny)


# cnt = 0 
# villiage = []

# for i in range(n):
#     for j in range(n):
#         if data[i][j] == 1 and visited[i][j] == False:
#             dfs(i, j)
#             villiage.append(cnt)
#             cnt = 0
# villiage.sort(key= lambda x:x)
# print(len(villiage))
# for i in villiage:
#     print(i)