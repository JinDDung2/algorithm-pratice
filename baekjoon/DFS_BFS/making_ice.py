# 음료수 얼려 먹기 DFS
# 4 5
# 00110
# 00011
# 11111
# 00000
n, m = map(int, input().split())
data = [list(map(int, input())) for _ in range(n)]
# print(data)

def goice(x, y):
    if x <= -1 or y <= -1 or x >= n or y >= m:
        return False
    
    if data[x][y] == 0:
        # print('ago', data)
        data[x][y] = 1
        # print('after', data)
        # print('---')
        goice(x, y+1)
        goice(x-1, y)
        goice(x, y-1)
        goice(x+1, y)
        return True
    return False

cnt = 0
for i in range(n):
    for j in range(m):
        if goice(i, j) == True:
            cnt += 1
            print(i, j, cnt)

print(cnt)