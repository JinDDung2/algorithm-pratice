# [S2] 연속합

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
dp = [0] * N
dp[0] = data[0]

for i in range(1, len(dp)):
    dp[i] = max(dp[i-1] + data[i], data[i])

print(max(dp))