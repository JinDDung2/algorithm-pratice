# 금광
# 최적 부분구조인가? O
# 중복되는 부분 구조인가? 모르겠네
import sys


def dynamic(result):
    dp = []
    idx = 0
    for _ in range(n):
        dp.append(data[idx:idx+m])
        idx += m
    
    for j in range(1, m):
        for i in range(n):
            if i == 0:
                leftUp = 0
            else:
                leftUp = dp[i-1][j-1]
            if i == n-1:
                leftDown = 0
            else:
                leftDown = dp[i+1][j-1]
            left = dp[i][j-1]
            dp[i][j] += max(left, leftDown, leftUp)

    for i in range(n):
        result = max(result, dp[i][m-1])

        return result

t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    data = list(map(int, sys.stdin.readline().split()))
    result = 0
    print(dynamic(0))


# 2
# 3 4
# 1 3 3 2 2 1 4 1 0 6 4 7
# 4 4
# 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

