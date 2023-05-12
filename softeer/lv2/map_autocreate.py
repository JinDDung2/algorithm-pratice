# 지도 자동 구축

import sys
N = int(sys.stdin.readline())
dp = [0] * 16
dp[0] = 2

for i in range(1, N+1):
    dp[i] = dp[i-1] + 2**(i-1)

print(dp[N]**2)

'''
import sys
import math
input = sys.stdin.readline

N = int(input())
dp = [0] * (17)
dp[1] = 2
for i in range(2, N+2):
    dp[i] = dp[i-1] + 2**(i-2)

print(dp[N+1] ** 2)
'''