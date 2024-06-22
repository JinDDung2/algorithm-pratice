# 알고리즘 수업 - 깊이 우선 탐색 1
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

# 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
N, M, R = map(int, input().split())
#  정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 
data = [[] for _ in range(N+1)]
count = 1
for _ in range(M):
    u, v = map(int, input().split())
    data[u].append(v)
    data[v].append(u)

# print(data)
visited = [0] * (N+1)

def dfs(start):
    global count
    visited[start] = count
    data[start].sort()

    for d in data[start]:
        if visited[d] == 0:
            count += 1
            # print(f"d={d}, visited[start]={visited[start]}")
            dfs(d)

dfs(R)
# print(visited)
for i in range(1, N+1):
    print(visited[i])

