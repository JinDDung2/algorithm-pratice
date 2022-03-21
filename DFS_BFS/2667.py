# 단지번호붙이기
n = int(input())
data = [list(map(int, input())) for _ in range(n)]
visited = []

for i in range(n):
    visited.append([False]*n)
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def dfs(x, y):
    global cnt
    visited[x][y] = True
    if data[x][y] == 1:
        cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if 0 <= nx < n and 0 <= ny < n:
            if visited[nx][ny] == False and data[nx][ny] == 1:
                dfs(nx, ny)


cnt = 0 
villiage = []

for i in range(n):
    for j in range(n):
        if data[i][j] == 1 and visited[i][j] == False:
            dfs(i, j)
            villiage.append(cnt)
            cnt = 0
villiage.sort(key= lambda x:x)
print(len(villiage))
for i in villiage:
    print(i)
