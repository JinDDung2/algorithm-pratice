# RGB거리
import sys

dp = []
# [[26, 40, 83], [49, 60, 57], [13, 89, 99]] 
#      빨강             초록            파랑
n = int(sys.stdin.readline())

for _ in range(n):
    cost = list(map(int, sys.stdin.readline().split()))
    dp.append(cost)
# print(data)

# N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
for i in range(1, n):
    # red
    dp[i][0] = dp[i][0] + min(dp[i-1][1], dp[i-1][2])
    # green
    dp[i][1] = dp[i][1] + min(dp[i-1][0], dp[i-1][2])
    # blue
    dp[i][2] = dp[i][2] + min(dp[i-1][0], dp[i-1][1])

# print(dp)
print(min(dp[n-1]))


