# 코딩테스트 고득점 Kit [정렬] 가장 큰 수

def solution(numbers):
    lst = []
    for i in numbers:
        lst.append(str(i))
    lst.sort(key = lambda x:(x*3), reverse= True)
    answer = ''.join(lst)
    return str(int(answer))

def try2(numbers):
    answer = ''
    
    if sum(numbers) == 0:
        return "0"
    
    lst = list(map(str, numbers))
    lst.sort(key= lambda x:(x*3), reverse=True)
    
    return "".join(lst)

number1 = [6, 10, 2] # "6210"
number2 = [3, 30, 34, 5, 9] # "9534330"
number3 = [0, 0] # 0
a = solution(number2)
print(a)