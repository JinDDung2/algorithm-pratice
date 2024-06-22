# 경로 찾기
# 노드 s에서 e까지 가는 데 걸리는 최단거리 -> 플로이드-워셜 알고리즘 -> 시간복잡도 O(V^3)
# for m in range(n): # 거쳐가는 노드
#     for s in range(n): # 시작 노드
#         for e in range(n): # 도착 노드
#             if graph[s][e] > graph[s][m] + graph[m][e]:
#                 graph[s][e] = graph[s][m] + graph[m][e]
# 그래서 bfs

import sys
input = sys.stdin.readline
n = int(input())

graph = []

for _ in range(n):
    lst = list(map(int, input().split()))
    graph.append(lst)

for m in range(n): # 거쳐가는 노드
    for s in range(n): # 시작 노드
        for e in range(n): # 도착 노드
            if graph[m][e] and graph[s][m]:
                graph[s][e] = 1

for l in graph:
    print(' '.join(map(str, l)))