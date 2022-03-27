# 벽을 부수고 이동하기
import sys
from collections import deque


n, m = map(int, input().split())    # n 세로 / m 가로
data = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[[0, 0] for _ in range(m)] for _ in range(n)]    # [[x][y][벽 부수기 전의 경우의 수 , 벽 한번부수고 난 후의 경우의 수]]
visited[0][0][0] = 1
# print(data)
# print('--')
# print(visited)

def bfs():
    que = deque()
    que.append([0, 0, 0])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while que:
        x, y, z = que.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][z]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if data[nx][ny] == 1 and z == 0:
                    visited[nx][ny][1] = visited[x][y][0] + 1
                    que.append([nx, ny, 1])
                elif data[nx][ny] == 0 and visited[nx][ny][z] == 0:
                    visited[nx][ny][z] = visited[x][y][z] + 1
                    que.append([nx, ny, z])
    return -1

                # 이동하는 경우의 수    
                # 벽이 있고 한번 부수고 이동할 때 2
                # 벽이 없고 방문한 적이 없을 때 1 

print(bfs())

# dfs
# def dfs(start, group):
#     visited[start] = group
#     for next in data[start]:
#         if visited[next] == 0:
#             ans = dfs(next, -group)
#             if not ans:
#                 return False
        
#         elif visited[start] == visited[next]:
#             return False

#     return True 

# k = int(input())
# ans = True

# for _ in range(k):
#     v, e = map(int, sys.stdin.readline().split())   # v = 노드 / e = 간선
#     data = [[] for _ in range(v+1)]
#     visited = [0] * (v+1)  
#     for i in range(e):
#         a, b = map(int, sys.stdin.readline().split())
#         data[a].append(b)
#         data[b].append(a)
    
#     for i in range(1, v+1):
#         if visited[i] == 0:
#             if ans:
#                 ans = dfs(i, 1)
#             else:
#                 break
            
#     if ans:
#         print('YES')
#     else:
#         print('NO')