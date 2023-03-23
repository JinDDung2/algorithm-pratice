# 개미 전사
N = int(input()) # 3 <= N <= 100
lst = list(map(int, input().split())) # 0 <= K <= 1000

dp = [0] * (N+1)
dp[0], dp[1] = lst[0], lst[1]

for i in range(2, N):
    dp[i] = max(lst[i]+dp[i-2], dp[i-1])

print(dp[N-1])
