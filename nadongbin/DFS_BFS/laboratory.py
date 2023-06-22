# 연구소
import sys
import copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
wall = []

def getCount(data: list) -> int:
    count = 0
    for i in range(N):
        for j in range(M):
            if data[i][j] == 0:
                count += 1
    return count

def bfs(data: list) -> list:
    new_data = copy.deepcopy(data)
    que = deque()
    for v in virus:
        que.append(v)

    while que:
        y, x = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if new_data[ny][nx] == 0:
                new_data[ny][nx] = 2
                que.append([ny, nx])

    return new_data

virus = []

for i in range(N):
    for j in range(M):
        if data[i][j] == 0:
            wall.append((i, j))
        elif data[i][j] == 2:
            virus.append((i, j))

result = getCount(bfs(data))

for c in combinations(wall, 3):
    one, two ,three = c[0], c[1], c[2]
    data[one[0]][one[1]] = 1
    data[two[0]][two[1]] = 1
    data[three[0]][three[1]] = 1
    d = bfs(data)
    result = max(result, getCount(d))
    data[one[0]][one[1]] = 0
    data[two[0]][two[1]] = 0
    data[three[0]][three[1]] = 0

print(result)
# test 1 -> 27
# 7 7
# 2 0 0 0 1 1 0
# 0 0 1 0 1 2 0
# 0 1 1 0 1 0 0
# 0 1 0 0 0 0 0
# 0 0 0 0 0 1 1
# 0 1 0 0 0 0 0
# 0 1 0 0 0 0 0

# test 2 -> 9
# 4 6
# 0 0 0 0 0 0
# 1 0 0 0 0 2
# 1 1 1 0 0 2
# 0 0 0 0 0 2

# test 3 -> 3
# 8 8
# 2 0 0 0 0 0 0 2
# 2 0 0 0 0 0 0 2
# 2 0 0 0 0 0 0 2
# 2 0 0 0 0 0 0 2
# 2 0 0 0 0 0 0 2
# 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0