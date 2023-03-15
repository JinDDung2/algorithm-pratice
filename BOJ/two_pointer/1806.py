# G4 부분합

import sys
input = sys.stdin.readline

N, S = map(int, input().split())
lst = list(map(int, input().split()))
# print(f"N={N}, S={S}, lst={lst}")

if sum(lst) < S:
    print(0)

s = 0
for i in range(len(lst)):
    s += lst[i]
    if s >= S:
        print(i+1)
        break
