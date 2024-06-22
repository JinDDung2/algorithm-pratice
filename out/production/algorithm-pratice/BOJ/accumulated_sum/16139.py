# [S1] 인간-컴퓨터 상호작용

import sys
input = sys.stdin.readline
S = input().rstrip()
lst = [[0] * 26 for _ in range(len(S))]
lst[0][ord(S[0])-97] = 1

# O(26 * 2000)
for i in range(1, len(S)):
    lst[i][ord(S[i])-97] = 1
    for j in range(26):
        lst[i][j] += lst[i-1][j]

# O(2000)
q = int(input())
for i in range(q):
    a, start, end = input().split()
    a, start, end = ord(a)-97, int(start), int(end)
    if start == 0:
        print(lst[end][a])
    else:
        print(lst[end][a] - lst[start-1][a])
