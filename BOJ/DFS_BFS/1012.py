# 유기농 배추
import sys
sys.setrecursionlimit(10**6)
t = int(input())
def dfs(x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if visited[nx][ny] == False and data[nx][ny] == 1:
                visited[nx][ny] = True
                dfs(nx, ny)
cnt_list = [] 
for _ in range(t):
    m, n, k = map(int, input().split()) # m 가로 / n 세로
    data = [[0]*m for _ in range(n)]
    visited = [[False]*m for _ in range(n)]
    cnt = 0
    for _ in range(k):
        a, b = map(int, input().split())
        data[b][a] = 1
    for i in range(n):
        for j in range(m):
            if data[i][j] == 1 and visited[i][j] == False:
                dfs(i, j)
                cnt += 1
    cnt_list.append(cnt)
for i in cnt_list:
    print(i)