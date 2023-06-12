# 볼링공 고르기
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = list(map(int, input().split()))
result = 0

arr = [0] * 11
for d in data:
    arr[d] += 1

for i in range(1, M+1):
    N -= arr[i]
    result += ( arr[i] * N )

print(result)

'''
# print(f"N={N}, M={M}, data={data}")

cnt = 0
for i in range(N):
    for j in range(i+1, N):
        if data[i] != data[j]:
            cnt += 1

print(cnt)

'''

# 5 3
# 1 3 2 3 2

# 8 5
# 1 5 4 3 2 4 5 2