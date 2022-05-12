# 가장 큰 수


def solution(numbers):
    lst = []
    for i in numbers:
        lst.append(str(i))
    lst.sort(key = lambda x:(x*3), reverse= True)
    answer = ''.join(lst)
    return str(int(answer))

number1 = [6, 10, 2] # "6210"
number2 = [3, 30, 34, 5, 9] # "9534330"
number3 = [0, 0] # 0
a = solution(number2)
print(a)