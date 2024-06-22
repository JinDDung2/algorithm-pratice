# 예상 대진표
# 88.2/100
def solution(n,a,b):
    answer = 0
    
    bigger_num = 0
    lower_num = 0
    if a > b:
        bigger_num = a
        lower_num = b
    else:
        bigger_num = b
        lower_num = a
    
    while True:
        answer += 1
        if bigger_num == lower_num+1: break
        
        if bigger_num%2==0:
            bigger_num //= 2
        elif bigger_num%2==1:
            bigger_num = (bigger_num//2) + 1
        if lower_num%2==0:
            lower_num //= 2
        elif lower_num%2==1:
            lower_num = (lower_num//2) + 1
        # print(f"round={answer}, big={bigger_num}, low={lower_num}")
    
    return answer

# 100 / 100
def solution2(n,a,b):
    answer = 0
    
    while a != b:
        answer += 1
        a, b = (a+1)//2, (b+1)//2
        # print(f"round={answer}, a={a}, b={b}")

    return answer
