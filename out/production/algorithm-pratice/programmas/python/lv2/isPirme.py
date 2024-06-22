# 소수찾기

from itertools import permutations

def isPrime(n):
    if n == 0 or n == 1:
        return False
    
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    answer = []
    for i in range(1, len(numbers)+1):
        lst = list(permutations(numbers, i))
        for j in range(len(lst)):
            num = int("".join(lst[j]))
            if isPrime(num):
                answer.append(num)
    
    answer = list(set(answer))
    return len(answer)