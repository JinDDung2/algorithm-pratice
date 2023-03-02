# 2018 KAKAO BLIND RECRUITMENT [3차] 파일명 정렬
import re

# 20개중 11개 케이스 성공
def incorrect_solution(files):
    answer = []
    # head(숫자전), number, tail(숫자후) 파싱 -> 숫자 기준으로 나누면 됨
    for file in files:
        head, number, tail = '', '', ''
        num_check = False
        for i in range(len(file)):
            if file[i].isdigit():
                number += file[i]
                num_check = True
            elif not num_check:
                head += file[i]
            else:
                # 이부분이 잘못
                tail += file[i]
        # print(f"head={head}, number={number}, tail={tail}")
        answer.append([head, number, tail])
    # head -> 사전순(대소문자 구분x) 람다1순위
    # files.sort(key=lambda x:x.lower())
    # head가 같다면? -> 숫자 순서대로 람다 2순위
    # 위의 두 조건마저 같다면? 기존의 순서대로
    answer.sort(key=lambda x:(x[0].lower(), int(x[1])))
    print(answer)
    result = list(''.join(file) for file in answer)
        
    return result

# 성공
def solution(files):
    answer = []
    # head(숫자전), number, tail(숫자후) 파싱 -> 숫자 기준으로 나누면 됨
    for file in files:
        head, number, tail = '', '', ''
        num_check = False
        for i in range(len(file)):
            if file[i].isdigit():
                number += file[i]
                num_check = True
            elif not num_check:
                head += file[i]
            else:
                tail += file[i:]
                break
        answer.append([head, number, tail])
    # head -> 사전순(대소문자 구분x) 람다1순위
    # head가 같다면? -> 숫자 순서대로 람다 2순위
    # 위의 두 조건마저 같다면? 기존의 순서대로
    answer.sort(key=lambda x:(x[0].lower(), int(x[1])))
    # print(answer)
    result = list(''.join(file) for file in answer)
        
    return result

    