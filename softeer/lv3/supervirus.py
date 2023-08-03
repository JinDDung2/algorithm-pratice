# 슈퍼 바이러스
import sys

input = sys.stdin.readline
# test 2
# K * P^10N
# f(2, 10) = f(2,5) * f(2,5)
# f(2, 5) = f(2, 2) * f(2, 2) * 2
# f(2, 2) = f(2, 1) * f(2, 1)
# f(2, 1) = 2
def dfs(p, n):
    if n == 1:
        return p
    elif n % 2 == 0:
        result = dfs(p, n / 2)
        return (result * result) % 1000000007
    else:
        result = dfs(p, n // 2)
        return (result * result * p) % 1000000007


K, P, N = map(int, input().split())
N = 10 * N
result = dfs(P, N)
result = result * K % 1000000007
print(result)

# test 1
'''
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
'''