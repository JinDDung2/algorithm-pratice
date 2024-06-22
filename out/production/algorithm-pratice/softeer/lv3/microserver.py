# [21년 재직자 대회 예선] 마이크로서버

import sys
input = sys.stdin.readline
T = int(input())
for i in range(T):
    M = int(input())
    data = list(map(int, input().split()))
    data.sort()
    start = 0
    end = len(data)-1
    count = 0
    # 300, 301~599, 600, 601~900
    num300 = 0
    for i in range(M):
        if data[i] > 300:
            break
        num300 += 1
        start += 1

    while start <= end and data[end] > 600:
        count += 1
        end -= 1
    while start < end and data[start] == 300 and data[end] == 600:
        count += 1
        start += 1
        end -= 1
    
    while start < end:
        if data[start] + data[end] <= 900:
            count += 1
            start += 1
            end -= 1
        elif num300 > 0:
            count += 1
            num300 -= 1
            end -= 1
        else:
            count += 1
            end -= 1
    
    if start == end:
        count += 1
        if num300 > 0:
            num300 -= 1

    count += ( (num300+2) // 3 )
    
    print(count)
