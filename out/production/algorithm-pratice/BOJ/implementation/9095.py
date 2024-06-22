# [S3] 1,2,3 더하기

import sys
input = sys.stdin.readline
dp = [0] * 12
dp[1], dp[2], dp[3] = 1, 2, 4
for i in range(4, len(dp)):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

T = int(input())
for _ in range(T):
    n = int(input())
    print(dp[n])

# 1 2 4 7 13 24