# 동계 테스트 예측 시점

import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 외부, 내부 분리
def divdeInAndOut():
    que = deque()
    visited = [[False] * M for _ in range(N)]
    que.append([0, 0])
    data[0][0] = 2
    visited[0][0] = True

    while que:
        y, x = que.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if visited[ny][nx]:
                continue
            if data[ny][nx] == 0 or data[ny][nx] == 2:
                data[ny][nx] = 2
                que.append([ny, nx])
                visited[ny][nx] = True
    

# 녹을 아이스 만들기
def melting(y, x):
    count = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= M or ny >= N:
            continue
        if data[ny][nx] != 2:
            continue
        count += 1
    
    if count >= 2:
        melting_ice.append([y, x])



input = sys.stdin.readline
N, M = map(int, input().split())
num_ice = 0
time = 0
data = list()
for _ in range(N):
    temp_list = list(map(int, input().split()))
    num_ice += temp_list.count(1)
    data.append(temp_list)

divdeInAndOut()

while num_ice > 0:
    melting_ice = []
    for i in range(N):
        for j in range(M):
            if data[i][j] == 1:
                melting(i, j)

    num_ice -= len(melting_ice)

    for i, j in melting_ice:
        data[i][j] = 2
    
    divdeInAndOut()
    time += 1

print(time)
    