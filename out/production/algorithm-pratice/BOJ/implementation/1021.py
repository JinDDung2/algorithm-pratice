# [S3] 회전하는 큐

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
que = [i for i in range(1, N+1)]
que = deque(que)
data = list(map(int, input().split()))
count = 0
result = []

for i in range(len(data)):
    idx = que.index(data[i])
    if idx == 0:
        result.append(que.popleft())
    else:
        if idx < (len(que) - idx):
            # 왼쪽으로 이동
            for i in range(idx):
                que.append(que.popleft())
                count += 1
            # 필요한 숫자 result에 넣기
        else:
            # 오른쪽으로 이동
            que.rotate(len(que) - idx)
            count += (len(que) - idx)
        result.append(que.popleft())

# print(result)
print(count)
        