# 게임 맵 최단거리
from collections import deque

def solution(maps):
    n = len(maps) # 세로
    m = len(maps[0]) # 가로
    
    if maps[n-1][m-2] == 0 and maps[n-2][m-1] == 0:
        return -1
    else:
        bfs(maps, n, m)
    return maps[n-1][m-1]


def bfs(maps, n, m):
    visited = [[False]*m for _ in range(n)]
    queue = deque()
    queue.append([0, 0])
    #  상 하 좌 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while queue:
        y, x = queue.popleft()
        visited[y][x] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if maps[ny][nx] == 1 and not visited[ny][nx]:
                    visited[ny][nx] == True
                    maps[ny][nx] = maps[y][x]+1
                    queue.append([ny, nx])
                    # print(f"maps[x][y]={maps[nx][ny]}")
    return maps


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
# print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))