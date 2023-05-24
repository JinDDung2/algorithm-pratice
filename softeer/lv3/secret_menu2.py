# [21년 재직자 대회 본선] 비밀 메뉴2

import sys
input = sys.stdin.readline
N, M, K = map(int, input().split())
A = list(input().split())
B = list(input().split())
C = [[0] * M for _ in range(N)]
result = 0

for i in range(N):
    for j in range(M):
        if A[i] == B[j]:
            if i == 0 or j == 0:
                C[i][j] = 1
            else:
                C[i][j] = C[i-1][j-1] + 1
            result = max(result, C[i][j])
            # print(i, j, C[i][j])

print(result)
