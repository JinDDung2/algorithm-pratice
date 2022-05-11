# 01타일
# 중복되는 부분 구조인가?

n = int(input())
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    if i <= 2:
        dp[i] = i
    else:
        dp[i] = (dp[i-1] + dp[i-2])%15746

print(dp[n])
# print(dp, dp[n])