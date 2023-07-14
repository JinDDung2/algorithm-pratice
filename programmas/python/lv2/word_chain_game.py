# 영어 끝말잇기

def solution(n, words):
    number = 0
    order = 0

    for i in range(1, len(words)):
        if words[i][0] != words[i-1][-1]:
            print(f"diff={i}")
            number = (i%n)+1
            order = (i//n)+1
            break
            
        elif words[i] in words[:i]:
            print(f"dupli={i}")
            number = (i%n)+1
            order = (i//n)+1
            break
            
    answer = [number, order]
    return answer