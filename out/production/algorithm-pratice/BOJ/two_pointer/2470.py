# [G5] 두 용액

import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
data.sort()

left = 0
right = N-1
temp = abs(data[left] + data[right])
result = [data[left], data[right]]

while left < right:
    leftNum = data[left]
    rightNum = data[right]
    sum = leftNum + rightNum

    if abs(sum) < temp:
        temp = abs(sum)
        result = [leftNum, rightNum]
        if temp == 0:
            break
    
    if sum < 0:
        left += 1
    else:
        right -= 1

print(*result)
