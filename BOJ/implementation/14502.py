#[G4] 연구소

import sys
import copy
from itertools import permutations
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

def bfs() -> list:
    global result
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
    
    result = max(result, countZero(new_data))


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

def wall_construct(wall_cnt):
    # 벽 3개 설치 완료 시, 바이러스 전파
    if wall_cnt == 3:
        bfs()
        return
    # 벽을 설치할 수 있는 모든 경우의 수 확인
    for n in range(N):
        for m in range(M):
            if data[n][m] == 0:
                data[n][m] = 1 # 벽 설치
                wall_construct(wall_cnt + 1)
                data[n][m] = 0 # 새로운 조합 만들기 위해 초기화

wall_construct(0)
print(result)

# for c in permutations(w, 3):
#     one, two, three = c[0], c[1], c[2]
#     data[one[0]][one[1]] = 1
#     data[two[0]][two[1]] = 1
#     data[three[0]][three[1]] = 1
#     # bfs, 개수 셈
#     d = bfs()
#     result = max(result, countZero(d))
#     data[one[0]][one[1]] = 0
#     data[two[0]][two[1]] = 0
#     data[three[0]][three[1]] = 0