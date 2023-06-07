# [S3] 2xn 타일링

N = int(input())
dp = [0] * (N+1)

if N == 1: print(1)
elif N == 2: print(2)
else:
    dp[1], dp[2] = 1, 2
    for i in range(3, N+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 10007

    print(dp[N])