# [G4] 연구소

import sys
import copy
from itertools import combinations
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())

def countZero(data: list) -> int:
    count = 0
    for i in range(N):
        for j in range(M):
            if data[i][j] == 0:
                count += 1
    
    return count

def bfs(d) -> list:
    new_data = copy.deepcopy(d)
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
    
    count = 0
    for i in range(N):
        for j in range(M):
            if data[i][j] == 0:
                count += 1
    
    return new_data


data = [list(map(int, input().split())) for _ in range(N)]
w = []
virus = []
result = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(N):
    for j in range(M):
        if data[i][j] == 0:
            w.append([i, j])
        elif data[i][j] == 2:
            virus.append([i, j])

for c in combinations(w, 3):
    one, two, three = c[0], c[1], c[2]
    data[one[0]][one[1]] = 1
    data[two[0]][two[1]] = 1
    data[three[0]][three[1]] = 1
    # bfs, 개수 셈
    d = bfs(data)
    result = max(result, countZero(d))
    data[one[0]][one[1]] = 0
    data[two[0]][two[1]] = 0
    data[three[0]][three[1]] = 0

print(result)