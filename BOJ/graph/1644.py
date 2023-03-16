# S2 트리의 부모 찾기
import sys
from collections import deque
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())
visited = [False] * (N+1)
# 부모 노드
p = [0] * (N+1)
# 트리
tree = [[] for _ in range(N+1)]
for _ in range(N-1):
    a, b = map(int, input().split())
    tree[b].append(a)
    tree[a].append(b)

# bfs
print(tree)
def bfs(node, visited, tree):
    q = deque([node])
    visited[node] = True
    while q:
        n = q.popleft()
        for i in tree[n]:
            if not visited[i]:
                visited[i] = True
                p[i] = n
                q.append(i)
                # print(f"visited={visited}, p={p}, idx={n}, i={i}")

bfs(1, visited, tree)

for i in range(2, N+1):
    print(p[i])