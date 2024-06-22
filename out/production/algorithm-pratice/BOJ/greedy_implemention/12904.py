# [G5] A와 B

import sys
input = sys.stdin.readline
T = list(input().rstrip())
S = list(input().rstrip())

# 문자열 A 추가
# 문자열 뒤집고 B 추가

# T 에서 S로 바꿔보자

while True:
    if not S:
        print(0)
        break
    if S == T:
        print(1)
        break
    
    if S[-1] == "A":
        S.pop()
    else:
        S.pop()
        S = S[::-1]
    # S.pop()
    # if S[-1] == "B":
    #     S = S[::-1]