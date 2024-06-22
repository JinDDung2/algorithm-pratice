# 뒤에 있는 큰 수 찾기
def solution(numbers):
    answer = [-1] * len(numbers)
    stack = [] # numbers의 idx값 넣어둘 곳 / 뒤에 큰값이 없을 경우 스택에 그대로 둠
    
    for i in range(len(numbers)):
        # print(f"i={i}, stack1={stack}")
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
            # print(f"i={i}, stack2={stack}")
        stack.append(i)
    return answer
# 시간초과
def incorr_solution(numbers):
    answer = []
    for i in range(len(numbers)):
        num = numbers[i]
        for j in range(i, len(numbers)):
            temp = max(num, numbers[j])
            if num != temp:
                answer.append(temp)
                break
        if num == temp:
            answer.append(-1)
    return answer