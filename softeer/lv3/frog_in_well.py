# 우물 안 개구리

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
w = [0] + list(map(int, input().split()))
friends = [[] for _ in range(N+1)]
count = 0

for _ in range(M):
    a, b = map(int, input().split())
    friends[a].append(b)
    friends[b].append(a)

for i in range(1, N+1):
    flag = True
    for f in friends[i]:
        if w[i] <= w[f]:
            flag = False
            break
    
    if flag:
        count += 1

print(count)