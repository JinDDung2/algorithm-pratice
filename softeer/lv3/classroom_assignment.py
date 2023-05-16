# 강의실 배정

import sys
import heapq

input = sys.stdin.readline
N = int(input())
heap = []

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