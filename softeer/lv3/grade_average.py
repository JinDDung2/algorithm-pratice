# 성적 평균

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
data = list(map(int, input().split()))

for _ in range(K):
    average = 0
    start, end = map(int, input().split())
    result = sum(data[start-1:end]) / (end-start+1)
    print(f"{result:.2f}")