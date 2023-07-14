# 다음 큰 숫자
def solution(n):
    idx = n+1
    count_one= bin(n)[2:].count('1')
    # print(count_one)
    while True:
        if bin(idx)[2:].count('1') == count_one:
            return idx
        idx += 1



print(solution(78))