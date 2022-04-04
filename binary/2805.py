# 나무 자르기
import sys


def solution():
    start = 0
    end = max(data)
    while start <= end:
        rest = 0
        h = (start+end)//2

        for x in data:
            if x > h:
                rest += x-h

        if rest >= m:
            start = h+1
        else:
            end = h-1
    
    return end
            

n, m = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))
print(solution())