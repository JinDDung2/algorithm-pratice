# 럭키 스트레이트
import sys
input = sys.stdin.readline

N = input().rstrip()
mid = len(N) // 2

left = N[:mid]
right = N[mid:]

s = 0

for i in range(mid):
    s += int(left[i])
    s -= int(right[i])

if s == 0:
    print("LUCKY")
else:
    print("READY")
# 123402 -> LUCKY
# 7755 -> READY