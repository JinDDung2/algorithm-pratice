# 바이러스
# num = int(input())
# connect = int(input())
# data = [[] for _ in range(num+1)]
# for _ in range(connect):
#     a, b = map(int, input().split())
#     data[a].append(b)
#     data[b].append(a)
# visited = [False] * (num+1)
# cnt = []
# def dfs(v, visited):
#     visited[v] = True
#     cnt.append(v)
#     for i in data[v]:
#         if not visited[i]:
#             dfs(i, visited)
# dfs(1, visited)
# print(len(cnt)-1)

from collections import deque
import sys
input = sys.stdin.readline
N = int(input()) # 1 <= N <= 100
M = int(input())

data = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int,input().split())
    data[a].append(b)
    data[b].append(a)

visited = [False] * (N+1)
que = deque([1])

while que:
    node = que.popleft()
    visited[node] = True
    for n in data[node]:
        if visited[n] == False:
            que.append(n)

cnt = 0
for i in range(2, N+1):
    if visited[i]:
        cnt += 1
print(cnt)
