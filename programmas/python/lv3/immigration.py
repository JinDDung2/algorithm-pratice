# 입국심사
# 정확성: 44.4
def solution(n, times):
    answer = 0
    # 시간을 탐색
    start = min(times)
    end = n * max(times)

    while start<=end:
        mid = (start+end) // 2
        people = 0

        for time in times:
            people += mid // time
        
        # 최대값을 줄여야함
        if people >= n:
            end = mid-1
        else:
            start = mid+1
    # 정확도 100
    answer = start

    return answer


print(solution(6, [7, 10]))