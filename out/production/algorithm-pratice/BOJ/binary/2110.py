# 공유기 설치
import sys


n, c = map(int, sys.stdin.readline().rstrip().split())
data = sorted([int(sys.stdin.readline()) for _ in range(n)])
start = 1
end = data[-1]

def solution(data, start, end):
    ans = 0

    while start <= end:
        router = data[0]    # 공유기 설치 첫 장소
        num = 1             # 공유기 개수 1개
        mid = (start+end)//2

        for i in range(1, n):
            if data[i] >= router + mid:
                num += 1
                router = data[i]
        
        if num >= c:
            start = mid+1
            ans = mid
        else:
            end = mid-1

    return ans

print(solution(data, start, end))