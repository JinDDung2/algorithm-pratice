# 화폐 가치

N, M = map(int, input().split()) # 1<= N<=100, 1<=M<=10000
coin = [int(input()) for _ in range(N)]
coin.sort()

dp = [10001] * (M+1)
dp[0] = 0

for i in range(N):
    for j in range(coin[i], M+1):
        if dp[j-coin[i]] != 10001:
            dp[j] = min(dp[j], dp[j-coin[i]]+1)

if dp[M] == 10001:
    print(-1)
else:
    print(dp[M])

# 2 15
# 2
# 3

# 3 4
# 3
# 5
# 7