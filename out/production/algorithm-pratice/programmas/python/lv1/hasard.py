# 하샤드 수

def solution(x):
    a = 0
    lenght = len(str(x))
    for i in range(lenght):
        a += int(str(x)[i])
    if x % a == 0:
        return True
    else:
        return False
    