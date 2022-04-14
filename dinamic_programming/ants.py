# 개미 전사
import sys


n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
dp = [0] * 100

def dynamic():
    dp[0] = data[0]
    dp[1] = max(data[0], data[1])
    for i in range(2, n):
        dp[i] = max(dp[i-1], dp[i-2]+data[i])
        # print(dp)
    
    return dp[n-1]


print(dynamic())
