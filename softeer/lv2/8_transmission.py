# 8단 변속기

import sys

input = sys.stdin.readline

data = list(map(int, input().split()))
result = ''
visited = [0, 0, 0, 0, 0, 0, 0, 0]

for i in range(1, len(data)):
    if data[i] == data[i-1] + 1:
        visited[i] = 0
    elif data[i] == data[i-1] - 1:
        visited[i] = 1
    else:
        visited[i] = -10

if sum(visited) > 0:
    result = 'descending'
elif sum(visited) == 0:
    result = 'ascending'
else:
    result = 'mixed'

print(result)