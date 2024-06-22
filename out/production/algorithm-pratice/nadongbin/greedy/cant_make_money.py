# 만들 수 없는 금액
import sys

input = sys.stdin.readline
N = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for d in data:
    if target < d:
        break
    target += d

print(target)
'''

target = 1
# 'target-1 까지의 모든 금액을 만들 수 있는 상태'
for num in data:
    if target < num:
        break
    target += num

print(target)

'''
# 5
# 3 2 1 1 9