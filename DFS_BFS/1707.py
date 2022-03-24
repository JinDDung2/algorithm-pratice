# 이분 그래프
# 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때
# print는 리턴 값이 없음
from collections import deque
from tokenize import group


def bfs(go):
    que = deque()
    que.append(go)
    visited[go] = 1
    g[go] = 1

    while que:
        print(que, 'v', visited)
        node = que.popleft()
        for next in data[node]:
            if visited[next] == 0:
                visited[next] = 1
                if g[node] == 1:
                    g[next] = 2
                elif g[node] == 2:
                    g[next] = 1
            elif visited[node] == visited[next]:
                if g[node] == g[next]:
                    print("거의 다왔쪄요")
                    return False
                else:
                    return True

ans = []       
k = int(input())    # 케이스 수
for _ in range(k):
    v, e = map(int, input().split())    # v는 노드 / e는 간선
    data = [[] for _ in range(v+1)]
    visited = [0] * (v+1)   # 0 방문없음 / 1 방문했쨔냐
    g = [0] * (v+1) # 그룹1/ 그룹2
    

    for _ in range(e):
        a, b = map(int, input().split())
        data[a].append(b)
        data[b].append(a)
    
    for i in range(1, v+1):
        if visited[i] == 0:
            bfs(i)

for _ in range(k):
    ans.append(bfs(i))
print(ans)

