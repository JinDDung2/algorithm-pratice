# [G3] 소수의 연속 합

import sys
input = sys.stdin.readline
num = int(input())

def prime(num):
    lst = []
    if num < 2:
        return lst
    if num >= 2:
        lst.append(2)

    for i in range(3, num+1):
        if isPrime(i):
            lst.append(i)
    
    return lst

def isPrime(num):
    if num == 1 or num == 2:
        return num
    
    for i in range(2, int(num ** 0.5)+1):
        if num % i == 0:
            return False

    return True

data = prime(num)
left = 0
right = 0
count = 0
sum = data[right]

while left <= right and left < len(data)-1 and right < len(data)-1:
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

print(count)