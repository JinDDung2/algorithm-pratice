# DFS와 BFS
from collections import deque
n, m, v = map(int, input().split())
data = []
for i in range(m):
    data.append(list(map(int, input().split())))
graph = [[] for _ in range(n+1)]
for i in data:
    for j in range(n+1):
        if i[0] == j:
            graph[j].append(i[1])
        if i[1] == j:
            graph[j].append(i[0])
for i in graph:
    i.sort()
visited_dfs = [False] * len(graph)
visited_bfs = [False] * len(graph)
def dfs(graph, v, visited_dfs):
    visited_dfs[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited_dfs[i]:
            dfs(graph, i, visited_dfs)
    return ''
def bfs(graph, v, visited_bfs):
    que = deque([v])
    visited_bfs[v] = True
    while que:
        search = que.popleft()
        print(search, end=' ')
        for i in graph[search]:
            if not visited_bfs[i]:
                visited_bfs[i] = True
                que.append(i)
    return ''
print(dfs(graph, v, visited_dfs))
print(bfs(graph, v, visited_bfs))
