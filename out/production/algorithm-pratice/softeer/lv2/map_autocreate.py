# 지도 자동 구축

import sys
import math

# test 2
input = sys.stdin.readline
N = int(input())
dp = [0] * 16
dp[0] = 4
# 4 -> 9 -> 25 -> 81
# 2 -> 3 -> 5 -> 9
for i in range(1, 16):
    dp[i] = int((math.sqrt(dp[i-1]) + 2**(i-1)) ** 2)

print(dp[N])

# test 1
'''
N = int(sys.stdin.readline())
dp = [0] * 16
dp[0] = 2

for i in range(1, N+1):
    dp[i] = dp[i-1] + 2**(i-1)

print(dp[N]**2)
'''