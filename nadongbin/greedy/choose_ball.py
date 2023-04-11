# 볼링공 고르기
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = list(map(int, input().split()))
# print(f"N={N}, M={M}, data={data}")

cnt = 0
for i in range(N):
    for j in range(i+1, N):
        if data[i] != data[j]:
            cnt += 1

print(cnt)

# 5 3
# 1 3 2 3 2

# 8 5
# 1 5 4 3 2 4 5 2