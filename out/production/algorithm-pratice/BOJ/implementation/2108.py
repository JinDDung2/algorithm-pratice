# [S3] 통계학

import sys
input = sys.stdin.readline
N = int(input())
data = []
count_num = [0] * 8001
for _ in range(N):
    num = int(input())
    data.append(num)
    count_num[num+4000] += 1
data.sort()
# 산술평균 : N개의 수들의 합을 N으로 나눈 값
print( round(sum(data) / N) )
# 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
print( data[len(data) // 2] )
# 최빈값 : N개의 수들 중 가장 많이 나타나는 값
count_most = []
count_max = max(count_num)
for i in range(len(count_num)):
    if count_num[i] == count_max:
        count_most.append(i-4000)

count_most.sort()
# print(count_most)
if len(count_most) < 2:
    print(count_most[0])
else:
    print(count_most[1])
# 범위 : N개의 수들 중 최댓값과 최솟값의 차이
print( max(data) - min(data) )