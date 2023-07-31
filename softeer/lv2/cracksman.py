# 금고 털이

# test 2
import sys

input = sys.stdin.readline
W, N = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
data.sort(key= lambda x:x[1], reverse=True)
result = 0

for d in data:
    if W == 0:
        break

    if W >= d[0]:
        W -= d[0]
        result += (d[0] * d[1])
    else:
        result += ( W * d[1] )
        W = 0

print(result)

# test 1
# import sys

# input = sys.stdin.readline
# W, N = map(int, input().split())

# data = []
# result = 0

# for _ in range(N):
#     M, P = map(int, input().split())
#     data.append([M, P])

# data.sort(key= lambda x:-x[1])

# for d in data:
#     if W <= 0:
#         break
#     if W >= d[0]:
#         result += (d[0] * d[1])
#         W -= d[0]
#     else:
#         result += (W * d[1])
#         W = 0

# print(result)