import sys

input = sys.stdin.readline
N = int(input().rstrip())
data = list(map(int, input().split()))

data.sort(reverse= True)
idx = 0
count = 0
while idx < len(data):
    idx += data[idx]
    count += 1

print(count)

# 5
# 2 3 1 2 2

# 6
# 1 1 1 1 1 1