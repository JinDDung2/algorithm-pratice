# 스마트 물류

import sys
input = sys.stdin.readline
N, K = map(int, input().split())
data = input().strip()
visited = [False] * len(data)
count = 0

for i in range(0, N):
    if data[i] == 'P': # 로봇이면 
        for j in range(i-K, i+K+1):
            if (i == j) or (j < 0) or (j >= N):
                continue
            if data[j] == 'H' and not visited[j]: # 가장 가까운 부품을 찾는다 (완전탐색)
                visited[j] = True
                #print(j)
                count += 1
                break

'''
for i in range(len(data)):
    chance = 1
    if data[i] == "P":
        for idx in range(K, 0, -1):
            if (i - idx) < 0:
                continue
            if data[i-idx] == "H" and not visited[i-idx]:
                count += 1
                visited[i-idx] = True
                chance -= 1
                break

        if chance == 1:
            for idx in range(1, K+1):
                if (i + idx) > len(data)-1:
                    continue
                if data[i+idx] == "H" and not visited[i+idx]:
                    count += 1
                    visited[i+idx] = True
                    break
'''
print(count)