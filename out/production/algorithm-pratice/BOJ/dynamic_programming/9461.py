# 파도반 수열
n = int(input())

for i in range(n):
    k = int(input())
    dp = [1]*(k+1)
    def sol(k):
        # print(dp, '1')
        for i in range(4, k+1):
            dp[i] = dp[i-2] + dp[i-3]
        # print(dp, '2')
        return dp[k]

    print(sol(k))

