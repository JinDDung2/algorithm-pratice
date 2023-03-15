# S3 두 수의 합
import sys
input = sys.stdin.readline
n = int(input())
lst = list(map(int, input().split()))
lst.sort()
x = int(input())

# print(f"n={n}, lst={lst}, x={x}")
ans = 0
left = 0
right = len(lst)-1
while left < right:
    if (lst[left] + lst[right]) == x:
        ans += 1
        # print(f"l={left}, r={right}, ans={ans}")
        left += 1
    if (lst[left] + lst[right]) < x:
        left += 1
    
    if (lst[left] + lst[right]) > x:
        right -= 1

print(ans)
