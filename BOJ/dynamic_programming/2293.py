# 동전 1
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
data = [int(input()) for _ in range(N)]
dp = [0] * (K+1)
dp[0] = 1

for d in data:
    for j in range(d, K+1):
        if j-d >= 0:
            dp[j] += dp[j-d]

print(dp)

# test 1 -> 10
# 3 10
# 1
# 2
# 5