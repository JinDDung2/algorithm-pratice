import sys

input = sys.stdin.readline

N, M = map(int, input().split())

limit_list = [0] * 101

start = 1
for _ in range(N):
    m, s = map(int, input().split())
    for i in range(start, start+m):
        limit_list[i] = s
    
    start += m

start = 1
result = 0
for _ in range(M):
    m, s = map(int, input().split())
    for i in range(start, start+m):
        result = max(result, s-limit_list[i])
    
    start += m

print(result)
