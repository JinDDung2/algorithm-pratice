# 개미 전사
# 최적 부분구조인가? 모르겠다
# 중복되는 부분 구조인가? O
import sys


n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
dp = [0] * 100

def dynamic():
    dp[0] = data[0]
    dp[1] = max(data[0], data[1])
    for i in range(2, n):
        dp[i] = max(dp[i-1], data[i]+dp[i-2])
        # print(dp)
    
    return dp[n-1]


print(dynamic()) 
