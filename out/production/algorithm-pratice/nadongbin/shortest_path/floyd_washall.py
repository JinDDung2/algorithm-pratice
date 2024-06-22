# 플로이드 워셜 알고리즘
N = int(input()) # 노드 개수
M = int(input()) # 간선 개수
INF = int(1e9)

# 그래프 만들기
graph = [[INF] * (N+1) for _ in range(N+1)]
# 자기 자신 비용은 0으로 초기화
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0
# 간선 초기화
for _ in range(M):
    # a -> b 비용은 c
    a, b, c = map(int, input().split())
    graph[a][b] = c
# 플로이드 워셜 점화식
for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
print(graph)
# 총 길이 최단거리
result = []
for i in range(1, N+1):
    m = INF
    for j in range(1, N+1):
        if graph[j][i] != 0 and graph[j][i] < m:
            m = graph[j][i]
    result.append(m)

print(result)
# 4
# 7
# 1 2 4
# 1 4 6
# 2 1 3
# 2 3 7
# 3 1 5
# 3 4 4
# 4 3 2