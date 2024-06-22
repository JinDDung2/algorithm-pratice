# 2020 KAKAO BLIND RECRUITMENT 문자열 압축

def solution(s):
    answer = []
    
    if len(s) == 1: return 1
    # 글자 단위로 자르기
    for i in range(1, (len(s)//2)+1):
        a = ''
        cnt = 1
        temp = s[:i] # 첫번째 미리 자르기
        
        for j in range(i, len(s)+1, i):
            if temp == s[j:i+j]: # 반복되는 문자열
                cnt += 1
            else: # 반복되는 문자열이 아님
                if cnt != 1: # 앞에 중복이 있었음
                    a += (str(cnt) + temp)
                else: # 앞에 중복 없음
                    a += temp
                
                temp = s[j:j+i]
                cnt = 1
        
        if cnt != 1:
            a += (str(cnt) + temp)
        else:
            a += temp
            
        answer.append(len(a))
        # print(f"answer={answer}, a={a}")
            
    return min(answer)

print(solution("aabbaccc"))