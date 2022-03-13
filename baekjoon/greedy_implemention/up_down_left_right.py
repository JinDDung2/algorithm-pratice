n = int(input())
a = input().split()
x, y = 1, 1
#동 북 서 남
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
move = ['R', 'U', 'L', 'D']

# while 1<=nx<=n and 1<=ny<=n:
#     for i in a:
#         for j in range(len(move)):
#             if i == move[j]:
#                 nx = x + dx[i]
#                 ny = y + dy[i]
#     x, y = nx, ny

# print(x, y)

for i in a:
    for j in range(len(move)):
        if i == move[j]:
            nx = x + dx[j]
            ny = y + dy[j]
            # print('1',i, nx, ny)
    if nx < 1 or ny < 1 or nx > n or nx > n:
        continue
    # print('2',i, nx, ny)
    x, y = nx, ny

print(x, y)