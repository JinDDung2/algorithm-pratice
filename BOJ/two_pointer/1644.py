# [G3] 소수의 연속 합

import sys
input = sys.stdin.readline
num = int(input())

# 에라토스테네스의 체
def prime(num):
    check = [True for _ in range(num+1)]
    for i in range(2, int(num ** 0.5)+1):
        if check[i] == True:
            for j in range(i+i, num+1, i):
                check[j] = False
    
    return [i for i in range(2, num+1) if check[i] == True]


data = prime(num)

# 투포인터
def two(data):
    left = 0
    right = 0
    count = 0
    sum = data[right]

    while left <= right and right < len(data)-1:
        if sum < num:
            right += 1
            sum += data[right]
        elif sum > num:
            sum -= data[left]
            left += 1

        if sum == num:
            count += 1
            right += 1
            sum += data[right]

    if data[-1] == num:
        count += 1

    return count

if num == 1:
    print(0)
else:
    print(two(data))