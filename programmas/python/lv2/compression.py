# 2018 KAKAO BLIND RECRUITMENT 압축
def solution(msg):
    answer = []
    dic = dict()
    
    for i in range(1, 27):
        dic[chr(i+64)] = i
    
    idx = 0
    # idx가 msg 길이가 같아질 때 까지 반복
    # idx + next_idx가 있다면 그 값 출력 / 없으면 그 값을 사전에 추가 후 idx의 값만 출력
    while True:
        plus_idx = idx
        # 다음값이 언제까지 있는지 확인
        while msg[idx:plus_idx+1] in dic and plus_idx < len(msg):
            plus_idx += 1
        # plus_idx 값이 msg 길이와 같아진다면 탈출
        if plus_idx == len(msg): break
        # 매칭된 문자열 출력 + 글자들 사전에 추가
        answer.append(dic[msg[idx:plus_idx]])
        dic[msg[idx:plus_idx+1]] = len(dic)+1
        # idx 값 재할당하기
        idx = plus_idx
    
    # 마지막 남은 문자열 출력
    answer.append(dic[msg[idx:plus_idx]])
    return answer