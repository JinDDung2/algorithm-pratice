# 배달

import heapq

INF = int(1e9)

def dijkstra(start, graph, distance):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    

def solution(N, road, K):
    graph = [[] for _ in range(N+1)]
    distance = [INF] * (N+1)
    
    for r in road:
        graph[r[0]].append((r[1], r[2]))
        graph[r[1]].append((r[0], r[2]))
    
    dijkstra(1, graph, distance)
    
    answer = 0
    for i in range(1, N+1):
        if distance[i] <= K:
            answer += 1

    return answer