# 2 x n 타일링
# 정확성 통과, 효율성 3/6 통과
def nopass_solution(n):
    dp = [0] * (n+1)
    dp[1], dp[2] = 1, 2
    for i in range(3, n+1):
        dp[i] = dp[i-2] + dp[i-1]
    
    return dp[n] % 1000000007

# 정확성 통과, 효율성 통과
def solution(n):
    dp = [0] * (n+1)
    dp[1], dp[2] = 1, 2
    for i in range(3, n+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 1000000007
    
    return dp[n]