import sys
input = sys.stdin.readline

N = input()
data = list(map(int, input().split()))
# print(data)
data.sort()

group = 0
cnt = 0 # 그릅 내의 인원

for num in data:
    cnt += 1
    if cnt >= num:
        group += 1
        cnt = 0

print(f"group={group}")

# 5
# 2 3 1 2 2

# 6
# 1 1 1 1 1 1