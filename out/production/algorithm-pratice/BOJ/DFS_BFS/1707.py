# 이분 그래프
# 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때
# print는 리턴 값이 없음
from collections import deque
import sys


def bfs(go):
    que = deque()
    que.append(go)
    visited[go] = 1
    # print(data)

    while que:
        print('이전', que, 'v', visited)
        node = que.popleft()
        # print('node', node)
        print('이후', que, 'v', visited)
        for next in data[node]:
            if visited[next] == 0:
                que.append(next)
                print('n', next)
                if visited[node] == 1:
                    visited[next] = 2
                    # que.append(next)
                if visited[node] == 2:
                    visited[next] = 1
                    # que.append(next)
            elif visited[node] == visited[next]:
                # print("거의 다왔음")
                return False

    return True

k = int(input())    # 케이스 수
for _ in range(k):
    v, e = map(int, sys.stdin.readline().split())    # v는 노드 / e는 간선
    data = [[] for _ in range(v+1)]
    visited = [0] * (v+1)   # 0 방문없음 / 그룹 1 / 그룹 2
    
    for _ in range(e):
        a, b = map(int, sys.stdin.readline().split())
        data[a].append(b)
        data[b].append(a)

    ans = True
    for i in range(1, v+1):
        if visited[i] == 0:
            # print('start', i)
            ans = bfs(i)
            if not ans:
                break

    if ans:
        print('YES')
    else:
        print('NO')


# DFS
# def dfs(start, group):
#     visited[start] = group
#     for next in data[start]:
#         if visited[next] == 0:
#             ans = dfs(next, -group)
#             if not ans:
#                 return False
        
#         elif visited[start] == visited[next]:
#             return False

#     return True 

# k = int(input())
# ans = True

# for _ in range(k):
#     v, e = map(int, sys.stdin.readline().split())   # v = 노드 / e = 간선
#     data = [[] for _ in range(v+1)]
#     visited = [0] * (v+1)  
#     for i in range(e):
#         a, b = map(int, sys.stdin.readline().split())
#         data[a].append(b)
#         data[b].append(a)
    
#     for i in range(1, v+1):
#         if visited[i] == 0:
#             if ans:
#                 ans = dfs(i, 1)
#             else:
#                 break
            
#     if ans:
#         print('YES')
#     else:
#         print('NO')

