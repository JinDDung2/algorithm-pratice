# 소수만들기
from itertools import combinations


def solution(nums):
    answer = 0
    items = list(combinations(nums, 3))

    for item in items:
        a = sum(item)
        isPrime = True

        for i in range(2, int(a**0.5)+1):
            if a % i == 0:
                isPrime = False

        if isPrime == True:
            answer += 1
            
    return answer


print(solution([1, 2, 3, 4]))
print(solution([1, 2, 7, 6, 4]))