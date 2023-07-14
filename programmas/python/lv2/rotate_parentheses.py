# 괄호 회전하기

def isBracket(s):
    stack = []
    
    for i in s:
        if len(stack) == 0:
            stack.append(i)
        else:
            if i == ")" and stack[-1] == "(":
                stack.pop()
            elif i == "]" and stack[-1] == "[":
                stack.pop()
            elif i == "}" and stack[-1] == "{":
                stack.pop()
            else:
                stack.append(i)
    
    # print(f"s={stack}")
    if len(stack) == 0:
        return 1
    else:
        return 0

def solution(s):
    answer = 0
    
    for i in range(len(s)):
        if isBracket(s) == 1: 
            answer += 1
        s = s[1:] + s[0]
    
    return answer