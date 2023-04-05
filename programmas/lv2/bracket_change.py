# 2020 KAKAO BLIND RECRUITMENT 괄호 변환
def solution(p):
    if isCorrect(p):
        return p

    answer = bracket(p)
    return answer

# step 2
def setUV(p):
    left, right = 0, 0
    for i in range(len(p)):
        if p[i] == '(':
            left += 1
        else:
            right += 1

        if left == right:
            u = p[:i+1]
            v = p[i+1:] if i+1 < len(p) else ''
            break
    return u, v

# step 3
def isCorrect(p):
    stack = []
    for a in p:
        if a == '(':
            stack.append(a)
        else:
            if len(stack) == 0:
                return False
            elif stack[-1] == '(':
                stack.pop()
    if len(stack):
        return False
    else:
        return True

    # step 4
def bracket(p):
    result = ''
    if len(p) == 0:
        return result

    u, v = setUV(p)
    # step 3-1
    if isCorrect(u):
        result = u + bracket(v)
    else:
        temp = '('
        temp += bracket(v)
        temp += ')'
        u = u[1:-1]
        for a in u:
            if a == '(':
                temp += ')'
            else:
                temp += '('
        result += temp
    return result