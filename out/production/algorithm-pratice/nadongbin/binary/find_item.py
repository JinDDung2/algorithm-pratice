import sys

def binary_search(start, end, lst, target):
    while start <= end:
        mid = (start + end) // 2
        if lst[mid] == target:
            return True

        elif lst[mid] < target:
            start = mid + 1
        else:
            end = mid-1
    
    return False

input = sys.stdin.readline
N = int(input()) # 1,000,000
store = list(map(int, input().split()))
store.sort()
M = int(input()) # 100,00
client = list(map(int, input().split()))

for num in client:
    if binary_search(0, N-1, store, num):
        print('yes', end=' ')
    else:
        print('no', end=' ')


# 5
# 8 3 7 9 2
# 3
# 5 7 9