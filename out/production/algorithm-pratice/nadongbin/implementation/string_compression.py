# 2020 KAKAO BLIND RECRUITMENT 문자열 압축

def solution(s):
    answer = len(s)
    if len(s) == 1:
        return 1

    # 미리 잘라놓기
    # 반복되는지 비교
    # 같으면 cnt += 1
    # str(cnt) + 반복되는 문자열
    # 배열에 길이 넣고 그중 최솟값을 리턴
    for i in range(1, len(s)//2 + 1):
        result = ''
        cnt = 1
        temp = s[:i]
        for j in range(i, len(s)+1, i):
            if temp == s[j:i+j]:
                cnt += 1
            else:
                if cnt >= 2:
                    result += str(cnt) + temp
                else:
                    result += temp
                
                temp = s[j:j+i]
                cnt = 1
        
        if cnt >= 2:
            result += (str(cnt) + temp)
        else:
            result += temp

        answer = min(answer, len(result))

    return answer

print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))
print(solution("abcabcdede"))
print(solution("abcabcabcdedededede"))