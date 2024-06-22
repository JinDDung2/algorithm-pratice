# 연습문제 하노이의 탑

def solution(n):
    answer = []

    def hanoi(n, start, end, inter):
        if n == 1:
            answer.append([start, end])
        else:
            hanoi(n-1, start, inter, end)
            hanoi(1, start, end, inter)
            hanoi(n-1, inter, end, start)

    hanoi(n, 1, 3, 2)
    return answer