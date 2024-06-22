# [S3] 프린터 큐
import sys
from collections import deque

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    data = list(map(int, input().split()))
    que = deque(data)
    result = 0

    while que:
        max_num = max(que)
        num = que.popleft()
        M -= 1

        # 제일 중요한게 나왔을 때
        if max_num == num:
            result += 1
            # 그게 M일때
            if M < 0:
                print(result)
                break
        # 중요한게 나오지 않았는데
        else:
            que.append(num)
            # M이 나올 때 다시 맨 뒤로
            if M < 0:
                M = len(que)-1