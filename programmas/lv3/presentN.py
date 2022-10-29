# N으로 표현
def solution(N, number):
    answer = 0
    if N == number:
        return 1

    dp = []
    # 최솟값이 8보다 크면 -1을 return 합니다.
    for cnt in range(1, 9):
        temp = set()
        temp.add(int(str(N)*cnt)) #5, 55, 555
        # print(set)
        for i in range(1, cnt):
            for first in dp[i-1]:#연산자 기준 앞에 오는 숫자
                for second in dp[cnt-i-1]: #연산자 기준 뒤에 오는 숫자
                    # 연산 순서가 바뀌어도 동일
                    temp.add(first+second)
                    temp.add(first*second)
                    # 연산 순서가 바뀌면 달라짐
                    temp.add(first-second)
                    temp.add(second-first)

                    if first != 0:
                        temp.add(second//first)
                    if second != 0:
                        temp.add(first//second)
        if number in temp:
                return cnt
        dp.append(temp)

    return -1


print(solution(5, 12))