# [lv2] 롤케이크 자르기

from collections import Counter

def solution(topping):
    answer = 0
    TP = Counter(topping)
    s = set()
    
    # 한쪽에 다 사전으로 다 모음. topping순으로 뺀 걸 동생껄로 가정, 동생은 set으로 설정
    # key에 대한 value가 0이면 삭제
    # 두 개의 길이가 같으면 +1
    for i in topping:
        TP[i] -= 1
        s.add(i)
        if TP[i] == 0:
            TP.pop(i)
        if len(TP) == len(s):
            answer += 1
    
    return answer