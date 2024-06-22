# 괄호 변환
import sys
input = sys.stdin.readline

def solution(s):
    answer = ""
    if s == "":
        return answer
    idx = balanced_index(s)
    u = s[:idx+1]
    v = s[idx+1:]
    if check_right(u):
        answer = u + solution(v)
    else:
        answer = "("
        answer += solution(v)
        answer += ")"
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == "(":
                u[i] = ")"
            else:
                u[i] = "("
        answer += "".join(u)
    
    return answer

def balanced_index(s):
    count = 0
    # 균형잡힌 문자열 인덱스
    for i in range(len(s)):
        if s[i] == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return i
    # 올바른 괄호 문자열 파악

def check_right(s):
    count = 0
    for i in s:
        if i == "(":
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True

print(solution("()))((()"))

# test 1 -> "(()())()"
# (()())()
# test 2 -> "()"
# )(
# test 3 -> "()(())()"
# ()))((()