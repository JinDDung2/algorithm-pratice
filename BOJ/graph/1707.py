# 이분 그래프
import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    que = deque()
    que.append(start)
    visited[start] = 1

    while que:
        node = que.popleft()

        for next in data[node]:
            if visited[next] == 0:
                que.append(next)
                if visited[node] == 1:
                    visited[next] = 2
                elif visited[node] == 2:
                    visited[next] = 1
            elif visited[node] == visited[next]:
                print(node, next)
                return False

    return True

K = int(input())
for _ in range(K):
    V, E = map(int, input().split())
    data = [[] for _ in range(V+1)]
    visited = [0] * (V+1)

    for _ in range(E):
        a, b = map(int, input().split())
        data[a].append(b)
        data[b].append(a)

    flag = True
    for i in range(1, V+1):
        if visited[i] == 0:
            flag = bfs(i)
            if not flag:
                break
    if flag:
        print("YES")
    else:
        print("NO")