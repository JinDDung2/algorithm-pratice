# RGB거리
import sys

data = []
n = int(sys.stdin.readline())
dp = [0] * (n+1)
for _ in range(n):
    cost = list(map(int, sys.stdin.readline().split()))
    data.append(cost)

