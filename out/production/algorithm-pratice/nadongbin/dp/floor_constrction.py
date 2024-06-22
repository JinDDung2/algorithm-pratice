# 바닥 공사

N = int(input()) # 1<=N<=1000
dp = [0] * 1001

dp[1] = 1
dp[2] = 3
for i in range(3, N+1):
    dp[i] = (dp[i-1] + 2*dp[i-2]) % 796796

print(dp[N])