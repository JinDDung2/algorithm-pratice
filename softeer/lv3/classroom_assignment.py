# 강의실 배정

import sys
import heapq

input = sys.stdin.readline
N = int(input())
heap = []

# test 2
for _ in range(N):
    # 빨리 끝날수록 많은 회의실 배정 -> end 기준 정렬
    s, e = map(int,input().split())
    heapq.heappush(heap, (e, s)) # O(Nlog(N))

# print(heap)
time = heapq.heappop(heap)[0]
result = 1

while heap:
    end, start = heapq.heappop(heap)
    if time <= start:
        result += 1
        time = end

print(result)


'''test1
# O(NlogN)
for _ in range(N):
    start, end = map(int, input().split())
    heapq.heappush( heap, (end, start) )

now = 0
count = 0

while heap:
    end, start = heapq.heappop(heap)
    if start >= now:
        count += 1
        now = end

print(count)
'''

# 시간초과
'''
input = sys.stdin.readline
N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]
count = 1
idx = 0
# O(NlogN)
data.sort(key= lambda x:x[1])

# O(N)
for i in range(1, N):
    if data[i][0] >= data[idx][1]:
        idx = i
        count += 1

# O(NlogN) + O(N) = O(N)
print(count)
'''