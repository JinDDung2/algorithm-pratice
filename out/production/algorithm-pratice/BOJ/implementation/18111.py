# [S1] 마인 크래프트
# python 실패, pypy 통과

import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
result = sys.maxsize
# 층수
idx = 0

# O(500*500*256)
# 모든 층을 확인
# 실제 층이 타겟 층보다 크면 차이만큼 더함(2s)
# 실제 층이 타겟 층보다 작으면 차이만큼 더함(1s)
for target in range(257):
    max_h, min_h = 0, 0

    for i in range(N):
        for j in range(M):
            if data[i][j] >= target:
                max_h += data[i][j] - target
            else:
                min_h += target - data[i][j]
    
    # 인벤토리에 여유가 있어야 놓을 수 있음
    if max_h + B >= min_h:
        if min_h + max_h * 2 <= result:
            result = min_h + max_h * 2
            idx = target

print(result, idx)