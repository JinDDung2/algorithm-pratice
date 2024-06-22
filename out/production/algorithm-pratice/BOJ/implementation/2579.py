# [S3] 계단 오르기

import sys
input = sys.stdin.readline

N = int(input())
data = [int(input()) for _ in range(N)]
dp = [0] * N
if len(data) <=2:
    print(sum(data))
else:
    dp[0] = data[0]
    dp[1] = dp[0] + data[1]

    for i in range(2, N):
        dp[i] = max( dp[i-3] + data[i-1] + data[i], dp[i-2] + data[i]  )
    print(dp[-1])