# 가장 먼 노드
from collections import deque
def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    d = [0] * (n+1)
    d[1] = 1
    for node in edge:
        a, b = node[0], node[1]
        graph[a].append(b)
        graph[b].append(a)
    
    q = deque([1])
    
    # 노드가 연결되어있는지 확인
    # d = min(이전노드의 값 + 1, 이동할 노드)
    while q:
        node = q.popleft()
        for dest in graph[node]:
            if not d[dest]:
                d[dest] = d[node] + 1
                q.append(dest)
    
    return d.count(max(d))