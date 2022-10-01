# 미로 탈출 BFS
# 5 6
# 101010
# 111111
# 000001
# 111111
# 111111
from collections import deque


n, m = map(int, input().split())
data = [list(map(int, input())) for _ in range(n)]
# print(data)
#우 하 좌 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
def escape(x, y):
    queue = deque()
    queue.append([x, y])
    while queue:
        x, y = queue.popleft()
        for i in range(len(dx)):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if data[nx][ny] == 0:
                continue
            if data[nx][ny] == 1:
                data[nx][ny] = data[x][y] + 1
                # print('ago', queue)
                queue.append([nx, ny])
                # print('after', queue)
                # print('---')
    return data[n-1][m-1]

print(escape(0, 0))

