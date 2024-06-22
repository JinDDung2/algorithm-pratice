# 성적 평균

import sys
input = sys.stdin.readline

# test 2
N, K = map(int, input().split())
data = list(map(int, input().split()))
for i in range(K):
    start, end = map(int, input().split())
    average = ( sum(data[start-1:end]) / (end - start + 1) )
    print(f"{average:.2f}")
# test 1
'''
N, K = map(int, input().split())
data = list(map(int, input().split()))

for _ in range(K):
    average = 0
    start, end = map(int, input().split())
    result = sum(data[start-1:end]) / (end-start+1)
    print(f"{result:.2f}")
'''