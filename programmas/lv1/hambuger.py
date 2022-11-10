# 햄버거 만들기
def solution(ingredient):
    answer = 0
    stack = []

    for ingred in ingredient:
        stack.append(ingred)
        if stack[-4:] == [1, 2, 3, 1]:
            answer += 1
            for i in range(4):
                stack.pop()
    
    return answer



a = [2, 1, 1, 2, 3, 1, 2, 3, 1]
print(solution(a))