# [S3] 구간 합 구하기 4

import sys
input = sys.stdin.readline
N, M = map(int, input().split())
data = [0] + list(map(int, input().split()))
dp = [0] * len(data)

for i in range(1, N+1):
    dp[i] = dp[i-1] + data[i]

for _ in range(M):
    start, end = map(int, input().split())
    print(dp[end] - dp[start-1])