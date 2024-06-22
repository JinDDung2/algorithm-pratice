# [S3] 병든 나이트
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
# 위 아래 최소 1칸이동
# 오른쪽으로만 최소 1칸 이동
# 조건1) 세로가 1이면 최댓값 1
# 조건2) 세로가 2일때 2번3번 반복 -> 최댓값 (M+1) // 2와 4중 작은값
# 조건3) 가로가 7미만이면 최댓값은 4와 M 중 작은값
# 조건4) 그외 M-7+5
result = 0
if N == 1:
    result = 1
elif N == 2:
    result = min(4, (M+1) // 2)
elif M < 7:
    result = min(4, M)
else:
    result = M-7+5

print(result)
