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

