# 다익스트라 알고리즘
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)
n, m = map(int, input().split()) # 노드, 간선 개수
start = int(input())
# 그래프, 거리 만들기
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)

# 간선 정보 입력 받기
for i in range(m):
    # a -> b 비용은 c
    a, b, c = map(int, input().split())
    # 인덱스 = 노드
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    # 시작 노드 큐에 삽입 (거리, 노드)
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        d, node = heapq.heappop(q)
        # 거리 비용이 크면 무시
        if distance[node] < d:
            continue
        # 현재 노드와 인접한 노드 확인
        for i in graph[node]:
            cost = d + i[1]
            # 현재 노드를 거치는 비용이 더 적은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)
print(distance)
# 6 11
# 1
# 1 2 2
# 1 3 5
# 1 4 1
# 2 3 3
# 2 4 2
# 3 2 3
# 3 6 5
# 4 3 3
# 4 5 1
# 5 3 1
# 5 6 2
