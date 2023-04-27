# 코딩테스트 고득점 Kit [탐욕법] 큰 수 만들기
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

def try2(number, k):    
    lst = []
    for num in number:
        if not lst:
            lst.append(num)
            continue
        
        if k > 0:
            while num > lst[-1]:
                lst.pop()
                k -= 1
                if not lst or k == 0:
                    break
            
        lst.append(num)
    
    if k > 0:
        for _ in range(k):
            lst.pop()
            
    return ''.join(lst)