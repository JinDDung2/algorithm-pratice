# Kruskal MST
# 참고 : https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
def solution(n, costs):
    answer = 0
    uni = [0] * (n + 1)
    # 1. 그래프의 간선들을 가중치의 오름차순으로 정렬한다.
    costs.sort(key = lambda x: x[2])
    for i in range(1,n + 1):
        uni[i] = i
    def union(x,y):
        # 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        a = find(x)
        b = find(y)
        if a != b:
            uni[a] = b
    def find(x):
        # 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if uni[x] == x: 
            return x
        # 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        return find(uni[x])
    for n1,n2,cost in costs:
        if find(n1) != find(n2):
            union(n1,n2)
            answer += cost
    return answer
# 2. 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택한다.
# 즉, 가장 낮은 가중치를 먼저 선택한다.
# 사이클을 형성하는 간선을 제외한다.
# 3. 해당 간선을 현재의 MST(최소 비용 신장 트리)의 집합에 추가한다.


# 플루이드 워셜
def incorr_solution(n, costs):
    answer = []
    INF = int(1e9)
    graph = [[INF] * n for _ in range(n)]
    
    # 자기 자신은 비용 = 0
    for i in range(n):
        for j in range(n):
            if i == j:
                graph[i][j] = 0
                
    # 간선 초기화
    for cost in costs:
        a, b, c = cost[0], cost[1], cost[2]
        graph[a][b] = c
    
    # 플로이드 워셜
    for k in range(n):
        for a in range(n):
            for b in range(n):
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
    
    # 길이 구하기
    # print(graph)
    for i in range(n):
        m = INF
        for j in range(n):
            if graph[j][i] != 0 and graph[j][i] < m:
                m = graph[j][i]
        answer.append(m)
                
    return sum(answer[1:])