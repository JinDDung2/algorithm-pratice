# 최적 부분구조인가? O
# 중복되는 부분 구조인가? O

# top-down -> memoization
def fibo(x):
    if x == 1 or x == 2:
        return 1

    if dp[x] != 0:
        return dp[x]
    
    dp[x] = fibo(x-1) + fibo(x-2)
    return dp[x]


dp = [0] * 100
print("topDowm : ", fibo(3))

# bottom-up -> DP table
d = [0] * 100
d[1], d[2] = 1, 1
n = 99

for i in range(3, n+1):
    d[i] = d[i-1] + d[i-2]

print("bottomUp : ", d[n])