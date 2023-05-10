# 벽을 부수고 이동하기
import sys
from collections import deque

def bfs():
    que = deque()
    que.append([0, 0, 0])

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while que:
        x, y, z = que.popleft()
        if x == N-1 and y == M-1:
            return visited[x][y][z]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if data[nx][ny] == 1 and z == 0:
                visited[nx][ny][1] = visited[x][y][0] + 1
                que.append([nx, ny, 1])
            elif data[nx][ny] == 0 and visited[nx][ny][z] == 0:
                visited[nx][ny][z] = visited[x][y][z] + 1
                que.append([nx, ny, z])
    
    return -1


input = sys.stdin.readline
N, M = map(int, input().split())
data = [list(map(int, input().strip())) for _ in range(N)]
visited = [[[0, 0] for _ in range(M)] for _ in range(N)]
visited[0][0][0] = 1

print(bfs())

'''
n, m = map(int, input().split())    # n 세로 / m 가로
data = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[[0, 0] for _ in range(m)] for _ in range(n)]    # [[x][y][벽 부수기 전의 경우의 수 , 벽 한번부수고 난 후의 경우의 수]]
visited[0][0][0] = 1

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
'''

# 시간 초과
'''
def bfs():
    que = deque()
    que.append([0, 0])
    new_data[0][0] = 1

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while que:
        y, x = que.popleft()
        # visited[y][x] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or ny >= N or nx >= M:
                continue
            if new_data[ny][nx] == 0:
                new_data[ny][nx] = new_data[y][x] + 1
                que.append([ny, nx])
    
    return new_data[N-1][M-1]

input = sys.stdin.readline
N, M = map(int, input().split())
data = [list(map(int, input().strip())) for _ in range(N)]
# visited = [[False] * M] * N
result = N*M

wall_list = []
for y in range(N):
    for x in range(M):
        if data[y][x] == 1:
            wall_list.append([y, x])

wall_que = deque(wall_list)

while wall_que:
    new_data = copy.deepcopy(data)
    y, x = wall_que.popleft()
    new_data[y][x] = 0
    temp = bfs()
    if temp:
        result = min(result, temp)
    # print(y, x, result, new_data)

if result == 0:
    result = -1
print(result)
'''