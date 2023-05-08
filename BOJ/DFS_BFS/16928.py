# 뱀과 사다리 게임
from collections import deque


def bfs():
    que = deque([1])
    while que:
        x = que.popleft()
        if x == 100:
            return data[x]
        
        for i in range(1, 7):
            next = x + i
            if next > 100:
                continue
            if next in m_dict.keys():
                next = m_dict[next]
            if next in n_dict.keys():
                next = n_dict[next]
            if not visited[next]:
                visited[next] = True
                data[next] = data[x] + 1
                que.append(next)


data = [0] * 101
visited = [False] * 101

n_dict = dict()
m_dict = dict()

N, M = map(int, input().split())
for _ in range(N):
    u, v = map(int, input().split())
    n_dict[u] = v
for _ in range(M):
    u, v = map(int, input().split())
    n_dict[u] = v

print(bfs())