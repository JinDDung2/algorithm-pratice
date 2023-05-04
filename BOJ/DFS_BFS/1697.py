# 숨바꼭질 5 17
from collections import deque

n, k = map(int, input().split())

def bfs(n):
    que = deque()
    que.append(n)

    dp = [0] * 100001

    while que:
        n = que.popleft()
        
        if n == k:
            break
        
        for next in (n-1, n+1, n*2):
            if 0 <= next < 100001 and not dp[next]:
                que.append(next)
                dp[next] = dp[n] + 1
    
    return dp[n]
        
print(bfs(n))

# go = deque()
# go.append(n)
# time = [0] * 100001
# visited = [False] * 100001
# visited[n] = True

# while go:
#     x = go.popleft()
#     if x == k:
#         print(time[x])
#         break
#     else:
#         for next_x in (x-1, x+1, x*2):
#             if 0 <= next_x <= 100000 and not visited[next_x]:
#                 go.append(next_x)
#                 visited[next_x] = True
#                 time[next_x] = time[x] + 1

