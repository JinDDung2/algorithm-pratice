# # 가운데를 말해요
import heapq

# 시간초과
# n = int(input())
# lst = []
# mid = 0
# for i in range(1, n+1):
#     num = int(input())
#     lst.append(num)
#     lst.sort()
#     mid = int(len(lst)/2)
#     # print(lst, "mid",mid, "?", len(lst))
#     if i % 2 == 0:
#         print(lst[mid-1])
#     else:
#         print(lst[mid])
    
n = int(input())
left = []
right = []
for i in range(n):
    num = int(input())
    if len(left) == len(right):
        heapq.heappush(left, -num)
    else:
        heapq.heappush(right, num)





