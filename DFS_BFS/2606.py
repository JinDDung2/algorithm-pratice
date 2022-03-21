# 바이러스
num = int(input())
connect = int(input())
data = [[] for _ in range(num+1)]
for _ in range(connect):
    a, b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)
visited = [False] * (num+1)
cnt = []
def dfs(v, visited):
    visited[v] = True
    cnt.append(v)
    for i in data[v]:
        if not visited[i]:
            dfs(i, visited)
dfs(1, visited)
print(len(cnt)-1)