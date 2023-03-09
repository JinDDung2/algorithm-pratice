# 단어 변환
# 80/100
def incorrect_solution(begin, target, words):
    answer = 0
    temp = begin
    
    if target not in words:
        return answer
    
    # word가 begin에 있는 값인거 확인 + target에 필요한지 확인
    for word in words:
        for i in range(len(word)):
            if target[i] == word[i] and word[i] != temp[i]:
                temp = temp.replace(temp[i], word[i])
                print(f"word={word}, temp={temp}, target={target}")
                answer += 1
                
    return answer

# 단어 변환을 할 필요가 없음 -> 다음 단어가 변환된 단어이기 때문
from collections import deque

def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return answer
    
    q = deque()
    q.append([begin, 0])
    # 두 단어가 1글자만 달라야함
    while q:
        temp, cnt = q.popleft()
        
        if temp == target:
            answer = cnt
            break
        
        for k in range(len(words)):
            temp_cnt = 0
            for i in range(len(temp)):
                if temp[i] != words[k][i]:
                    temp_cnt += 1
            if temp_cnt == 1:
                q.append([words[k], cnt+1])
        
    return answer
