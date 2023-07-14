# 부족한 금액 계산하기

def solution(price, money, count):
    answer = -1
    a = 0
    for i in range(1, count+1):
        a += (price * i)
        print(a)
    answer = a-money

    if money < a:
        return answer
    else:
        return 0


print(solution(3, 20, 4))