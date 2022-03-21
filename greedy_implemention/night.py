data = input()
row = ['1', '2', '3', '4', '5', '6', '7', '8']
col = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']

x, y = row.index(data[1]), col.index(data[0])
#왼2위1 왼2아1, 우2위1,우2,아1, 위2왼1, 우2오1, 아2왼1, 아2오2
dx = [-1, 1, -1, 1, -2, -2, 2, 2]
dy = [-2, -2, 2, 2, -1, 1, -1, 1]
cnt = 0
 
for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < 8 and 0 <= ny < 8:
        cnt += 1
    else:
        continue

print(cnt)