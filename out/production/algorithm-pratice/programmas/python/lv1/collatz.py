# 콜라츠 추축

def solution(num):
    answer = 0
    cnt = 0
    while cnt <= 500:
        if num == 1:
            return cnt
        if cnt == 500:
            return -1
        
        if num % 2 == 0:
            num //= 2
        elif num % 2 != 0:
            num = num*3 + 1
        cnt += 1