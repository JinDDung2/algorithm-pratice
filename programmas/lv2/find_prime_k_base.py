# k진수에서 소수 개수 구하기

# 첫번째시도 실패 | 정확성: 85.7 합계: 85.7/100.0
def solution(n, k):
    answer = 0
    num = convert(n, k)
    # print(num)
    numList = num.split('0')
    for i in numList:
        if i != "" and isPrime(int(i)):
            answer += 1
            
    return answer

def convert(num, base):
    temp = ""
    while num:
        temp = str(num%base) + temp
        num //= base
        
    return temp

def isPrime(n):
    if n == 1:
        return False
    else:
        for i in range(2, int(n**0.5)+1):
            if n % i == 0:
                break
                return False
    return True
