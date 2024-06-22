# 바이러스

import sys

input = sys.stdin.readline

K, P, N = map(int, input().split()) # K= 바이러스 수, P= 증가율, N= 총 시간

# test 2
for _ in range(N):
    K = (K * P) % 1000000007
print(K)

# test 1
'''
for _ in range(N):
    K = (K * P) % 1000000007

print(K)
'''
