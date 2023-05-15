# 슈퍼 바이러스
import sys

input = sys.stdin.readline

# P^10N에서 P의 지수인 10N을 재귀적으로 나눠준다.
def dfs(x, y):
    if y == 1:
        return x
    elif y % 2 == 0:
        a = dfs(x, y / 2)
        return (a * a) % 1000000007
    else:
        b = dfs(x, y // 2)
        return (b * b * x) % 1000000007
    
K, P, N = map(int ,input().split())

N = 10 * N
result = dfs(P, N)
result *= K
print(result % 1000000007)