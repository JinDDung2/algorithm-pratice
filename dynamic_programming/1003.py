# 최적 부분구조인가? O
# 중복되는 부분 구조인가? O
import sys


t = int(sys.stdin.readline())

for i in range(t):
    n = int(sys.stdin.readline())
    cnt_0 = [1, 0]
    cnt_1 = [0, 1]
    
    if n >= 2:
        for i in range(2, n+1):
            cnt_0.append(cnt_0[i-1] + cnt_0[i-2])
            cnt_1.append(cnt_1[i-1] + cnt_1[i-2])
    
    print(cnt_0[n], cnt_1[n])