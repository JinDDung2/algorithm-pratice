# 기지국 설치
def incorrect_solution(n, stations, w):
    answer = 0
    l = len(stations)-1

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    for i in range(len(stations)):
        # 0부터 i[0]까지 설치 개수
        if i == 0:
            answer += (stations[i] // (2*w+1))
            print(f"0 | answer={answer}")
        # i의 값들끼리 설치 개수
        if 0 <= i < l:
            answer += ( (stations[i+1] - stations[i]) // (2*w+1) )
            print(f"1 | answer={answer}")
        # i[-1]부터 n까지 설치 개수
        if i == l:
            answer += ( (n-stations[-1]) // (2*w+1) )
            print(f"2 | answer={answer}")
            
    return answer

import math
def solution(n, stations, w):
    answer = 0
    W = 2*w+1
    
    # 시작 하는 곳 기억하기
    start = 1
    for s in stations:
        answer += math.ceil((s - w - start) / W)
        start = s + w + 1
        # print(f"answer={answer}, start={start}")
    
    if n >= start:
        answer += math.ceil((n - start + 1) / W)

    return answer