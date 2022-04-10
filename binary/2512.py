# 예산
import sys


def findAmount():
    start = 1
    end = max(data)
    ans = 0
    while start <= end:
        total = 0
        mid = (start+end)//2
        for i in data:
            if i > mid:
                total += mid
            else:
                total += i
        
        if total <= total_amount:
            start = mid+1
            ans = mid

        else:
            end = mid-1
            
    return ans


n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))
total_amount = int(sys.stdin.readline())

print(findAmount())
