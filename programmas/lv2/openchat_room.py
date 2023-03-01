# 2019 KAKAO BLIND RECRUITMENT 오픈채팅방
def solution(record):
    answer = []
    member = dict()
    for rec in record:
        temp = rec.split()
        if temp[0] == 'Enter':
            member[temp[1]] = temp[2]
        elif temp[0] == 'Change':
            member[temp[1]] = temp[2]
        # print(f"rec={rec}, member={member}")
    
    info = dict()
    info['Enter'] = '들어왔습니다.'
    info['Leave'] = '나갔습니다.'
    for rec in record:
        temp = rec.split()
        temp_str = ''
        if temp[0] in info:
            temp_str += info[temp[0]]
            if temp[1] in member:
                temp_str = member[temp[1]] + '님이 ' + temp_str
                answer.append(temp_str)
        # print(f"rec={rec}, temp_str={temp_str}")
    return answer
