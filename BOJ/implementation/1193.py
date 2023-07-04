# [S5] 분수 찾기

import sys
input = sys.stdin.readline
N = int(input())

# 1/1 1/2 2/1 3/1 2/2 1/3 1/4 2/3 3/2
# 아래1 -> 1 3 6 10 15
# 짝수 -> 분모+=1, 분자-=1
# 홀수 -> 분자+=1, 분모-=1

line = 1
while N > line:
    N -= line
    line += 1
    # print(f"N={N}, line={line}")

if line % 2 == 0:
    top = N
    bottom = line - N +1
else:
    top = line - N + 1
    bottom = N

print(f"{top}/{bottom}")