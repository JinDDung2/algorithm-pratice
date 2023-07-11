# [G5] 달력
import sys
input = sys.stdin.readline

N = int(input())
data = []
for i in range(N):
    data.append(list(map(int, input().split())))

date = [0] * 366

def cotting():
    for d in data:
        start = d[0]
        end = d[1]
        for i in range(start, end+1):
            date[i] += 1

    w = 0
    h = 0
    result = 0

    for i in range(len(date)):
        if date[i] == 0:
            result += (w * h)
            # print(f"l={left}, r={right}, w={w}, result={result}")
            w = 0
            h = 0
            continue
        w += 1
        h = max(h, date[i])
    # 마지막 날이 0이 아닐수도 있으니
    result += (w*h)
    
    return result

print(cotting())