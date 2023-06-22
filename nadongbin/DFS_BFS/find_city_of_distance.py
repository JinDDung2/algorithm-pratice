# 특정 거리의 도시 찾기
import sys
from collections import deque
input = sys.stdin.readline

N, M, K, X = map(int, input().split())
data = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    data[A].append(B)

d = [-1] * (N+1)
d[X] = 0

que = deque([X])
while que:
    now = que.popleft()
    for next in data[now]:
        # 방문하지 않았으면
        if d[next] == -1:
            d[next] = d[now] + 1
            que.append(next)

check = False
for i in range(1, N+1):
    if d[i] == K:
        print(i)
        check = True

if not check:
    print(-1)

# test 1 -> 4
# 4 4 2 1
# 1 2
# 1 3
# 2 3
# 2 4

# test 2 -> 2
# 4 3 2 1
# 1 2
# 1 3
# 1 4

# test 3 -> 2 3
# 4 4 1 1
# 1 2
# 1 3
# 2 3
# 2 4