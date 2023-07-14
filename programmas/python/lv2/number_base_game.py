# 2018 KAKAO BLIND RECRUITMENT [3차] n진수 게임
def solution(n, t, m, p):
    total = ''
    answer = ''
    for i in range(t**2):
        total += convert(i, n)
    
    for i in range(len(total)):
        if (i % m) == (p - 1):
            answer += total[i]
        if len(answer) == t:
            break
        
    return answer

def convert(number, base):
    T = "0123456789ABCDEF"
    q, r = divmod(number, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]