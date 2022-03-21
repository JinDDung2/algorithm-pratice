# 회의실 배정
n = int(input())
times = [list(map(int, input().split())) for _ in range(n)]
cnt = 1
times.sort(key= lambda x:(x[0]))
times.sort(key= lambda x:(x[1]))
print(times)

use = times[0][1]
for i in range(n-1):
    if use <= times[i+1][0]:
        cnt += 1
        use = times[i+1][1]

print(cnt)

# #충연
# n = int(input())
# data = [list(map(int, input().split())) for _ in range(n)]
# data.sort(key=lambda x: (x[1], x[0]))
# i = 1
# answer = [data[0]]
# while i < len(data):
#     if answer[-1][1] <= data[i][0]:
#         answer.append(data[i])
#         i += 1
#     else:
#         i += 1
# n = len(answer)
# print(n)

# #인한
# n = int(input())
# data = []
# for i in range(n):
#     m, k = map(int, input().split())
#     data.append((m, k))

# data.sort(key=lambda x: (x[1], x[0]))
# cnt = 1
# h = data[0][1]
# for i in range(1, len(data)):
#     c = data[i]
#     if c[0] >= h:
#         h = c[1]
#         cnt += 1
# print(cnt)