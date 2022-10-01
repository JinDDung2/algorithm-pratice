# 랜선 자르기
import sys


def binary():
    start = 1
    end = max(data)

    while start <= end:
        num = 0
        cut = (start+end) // 2

        for i in data:
            num += i // cut
        # print(start, end, cut, num)
        if num >= n:
            start = cut+1

        else:
            end = cut-1
    
    return end

k, n = map(int, sys.stdin.readline().split()) # k는 이미 가지고 있는 랜선의 개수 / n은 필요한 랜선의 개수
data = [int(sys.stdin.readline().strip()) for _ in range(k)]

print(binary())
