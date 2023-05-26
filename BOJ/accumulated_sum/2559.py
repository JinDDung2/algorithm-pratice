# [S3] 수열

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
data = list(map(int, input().split()))
dp = []
dp.append(sum(data[:K]))
for i in range(N-K):
    dp.append(dp[i] + data[i+K] - data[i])

# print(dp)
print(max(dp))