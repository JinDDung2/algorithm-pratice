# 전력망을 둘로 나누기
from collections import deque


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    cnt = 0

    while queue:
        x = queue.popleft()
        cnt += 1

        for i in graph[x]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


    return cnt

def solution(n, wires):
    answer = n-2 # 최대 n-2개

    for i in range(len(wires)):
        temps = wires.copy()
        graph = [[] for i in range(n+1)]
        visited = [False] * (n+1)
        temps.pop(i)

        # 연결된 곳들 파악
        for wire in temps:
            x, y = wire
            graph[x].append(y)
            graph[y].append(x)
        
        # start 변경로직
        for idx, check in enumerate(graph):
            if check != []: 
                start = idx
                break
        
        # 개수 
        first_cnts = bfs(graph, start, visited)
        second_cnts = (n - first_cnts)

        if abs(first_cnts - second_cnts) < answer:
            answer = abs(first_cnts - second_cnts)


    return answer



graph = [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]

print(solution(9, graph))