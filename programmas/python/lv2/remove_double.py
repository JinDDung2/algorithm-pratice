# 짝 지어 제거하기
def solution(s):
    answer = 1

    stack = []
    for i in range(len(s)):
        if len(stack) == 0:
            stack.append(s[i])
        elif stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])
    
    if len(stack) != 0:
        answer = 0

    return answer


s1 = "baabaa"
s2 = "cdcd"

print(solution(s2))