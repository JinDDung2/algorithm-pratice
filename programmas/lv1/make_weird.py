# 이상한 문자 만들기

def solution(s):
    answer = []
    a = s.split(' ')
    for x in a:
        word = ''
        for i in range(len(x)):
            if i % 2 == 0:
                word += x[i].upper()
            else:
                word += x[i].lower()
        answer.append(word)

    return ' '.join(answer)


print(solution("try hello world"))