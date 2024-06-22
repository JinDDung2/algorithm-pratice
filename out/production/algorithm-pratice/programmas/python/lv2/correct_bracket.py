# 코딩테스트 고득점 Kit [스택/큐] 올바른 괄호
def solution(s):
    answer = True
    s = list(s)
    bracket = []
    
    while s:
        b = s.pop()
        if b == ")":
            bracket.append("b")
        else:
            if not bracket:
                return False
            else:
                bracket.pop()
    
    if bracket:
        return False

    return True