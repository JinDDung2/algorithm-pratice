# 우물 안 개구리

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
w = [0] + list(map(int, input().split()))
friends = [[] for _ in range(N+1)]

def isStronger(power, lst):
    for l in lst:
        if power <= W[l]:
            return False
    return True

friends = [[] for _ in range(N+1)]
result = 0
for d in friends:
    p1, p2 = d[0], d[1]
    friends[p1].append(p2)
    friends[p2].append(p1)

for i in range(1, len(friends)):
    if isStronger(W[i], friends[i]):
        result += 1

print(result)
'''test 1
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
'''