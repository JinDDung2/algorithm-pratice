# G4 부분합

import sys
input = sys.stdin.readline

N, S = map(int, input().split())
lst = list(map(int, input().split()))
# print(f"N={N}, S={S}, lst={lst}")

left, right = 0, 0
s = 0
min_lenght = sys.maxsize

while True:
    # 총합이 S넘으면 left를 증가시키면서 어디까지 줄어드나 확인
    if s >= S:
        min_lenght = min(min_lenght, (right-left))
        s -= lst[left]
        left += 1
    # right가 N과 같을 때 탈출
    elif right == N:
        break
    # 총합이 S넘지 않으면 총합이 S넘을때 까지 right를 증가시키면서
    else:
        s += lst[right]
        right += 1

if min_lenght == sys.maxsize:
    print(0)
else:
    print(min_lenght)