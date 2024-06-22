# 연결 요소의 개수

import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

# dfs
def dfs(start, depth):
    # dfs 탐색 시작
    vistied[start] = True
    for node in graph[start]:
        if not vistied[node]:
            dfs(node, depth + 1)

# n, m 값 | 그래프 | 방문처리 | 연결 요소 개수
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

vistied = [False] * (n+1)
cnt = 0

# bfs
from collections import deque

def bfs(start):
    que = deque([start])
    vistied[start]= True
    while que:
        node = que.popleft()
        for i in graph[node]:
            if not vistied[i]:
                vistied[i] = True
                que.append(i)

for node in range(1, n+1):
    # 방문한 적 없는 곳을 방문해야함
    if not vistied[node]:
        # 연결된 곳이 아닐 경우 -> 연결이 끝났을 경우
        if not graph[node]:
            cnt += 1
            vistied[node] = True
            # print(f"node={node}, cnt1={cnt}, visited={vistied}, graph={graph}")
        # 연결된 곳
        else:
            # print(f"cnt2={cnt}")
            # dfs(node, 0)
            bfs(node)
            cnt += 1

print(cnt)
