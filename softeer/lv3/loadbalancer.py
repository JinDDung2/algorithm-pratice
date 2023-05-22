# [21년 재직자 대회 예선] 로드 밸런서 트래픽 예측

import sys
from collections import deque
input = sys.stdin.readline

def ts():
    que = deque()
    que.append(1)

    while que:
        now = que.popleft()
        sequence.append(now)

        for c in graph[now]:
            data[c] -= 1
            if data[c] == 0:
                que.append(c)

N, K = map(int, input().split())
graph = [[] for _ in range(N+1)]
data = [0] * (N+1)

sequence = []

for i in range(1, N+1):
    info = list(map(int, input().split()))

    # worker
    if info[0] == 0:
        graph[i].append(0)
    # loadbalancer
    else:
        graph[i] += info[1:]
        for c in info[1:]:
            data[c]+=1

ts()
# 1 5 8 2 4 3 6 7
# print(graph)
# print(sequence)

count = [0] * (N+1)
count[1] = K

for s in sequence:
    r = count[s]

    chileNum = len(graph[s])
    if chileNum == 0:
        continue
    
    a = r // chileNum
    b = r % chileNum
    # 1 -> 2, 5, 7 (2개씩)
    # 5 -> 2, 8
    # 8 -> 6, 7
    # 2 -> x
    # 4 -> x
    # 3 -> x
    # 6 -> x
    # 7 -> x
    for c in graph[s]:
        count[c] += a
    for i in range(b):
        c = graph[s][i]
        count[c] += 1

for i in range(1, N+1):
    print(count[i], end=' ')