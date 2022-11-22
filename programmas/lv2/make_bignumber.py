# 큰 수 만들기
def solution(number, k):
    answer = []
    for num in number:
        if not answer:
            answer.append(num)
            # print(answer)
            continue
        # k를 줄여서 0이되면 리턴
        if k > 0:
            while num > answer[-1]:
                answer.pop()
                k -= 1
                if not answer or k == 0:
                    break
        answer.append(num)
        # print(answer)
        # "4321", 1, "432"
    # print(answer)
    result = answer[:len(number)-k]
    # print(result)
    
    return ''.join(result)