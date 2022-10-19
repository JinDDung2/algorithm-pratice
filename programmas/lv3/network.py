# 네트워크
from collections import deque

# 연결되어 있으면 True
def bfs(n, computers, node, visited):
    
    if visited[node]==True:
        return False
    
    queue = deque([computers[node]])
    visited[node] = True
    
    while queue:
        check = queue.popleft()
        # 네트워크 연결되어있는지 체크
        for i in range(n):
            # 자기자신 아니고, 연결(1)되어 있어야하고, 방문한적 없고
            if i!=node and check[i]==1 and visited[i] == False:
                visited[i] = True
                queue.append(computers[i])
                    
    return True

def solution(n, computers):
    global visited
    visited = [False] * n
    network = 0

    for node in range(n):
        if bfs(n, computers, node, visited):
            network += 1

    return network


# print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))