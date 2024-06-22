# 플로이드 워셜 -> 모든 노드를 지나는 최단거리
'''
N = int(input()) # 노드 개수
M = int(input()) # 간선 개수
INF = int(1e9)

# 그래프 만들기
graph = [[INF] * (N+1) for _ in range(N+1)]
# 자기 자신 비용 0
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0
# 간선 초기화 a, b -> c 비용
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c
# 플로이드 워셜 점화식
for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(2, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

result = []
for i in range(1, N+1):
    m = INF
    for j in range(1, N+1):
        if graph[j][i] != 0 and graph[j][i] < m:
            m = graph[j][i]
    result.append(m)
print(f"graph={graph}")
print(f"result={result}")
'''
# 다익스트라 -> 출발지부터 목적지까지 최단 거리
import heapq
import sys
# 그래프, 거리
input = sys.stdin.readline
INF = int(1e9)
n, m = map(int, input().split()) # 노드, 간선 개수
start = int(input())
# 그래프, 거리 만들기
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)

# 간선 초기화
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dj(start):
    q = []
    heapq.heappush(q, (0, start))
    while q:
        d, node = heapq.heappop(q)
        # 거리 비용이 이전보다 크면 무시
        if distance[node] <= d:
            continue
        # 인접한 노드 확인
        for i in graph[node]:
            cost = d + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

print(graph)
dj(start)
print(distance[2:])

