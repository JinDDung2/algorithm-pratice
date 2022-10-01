# 감시
n, m = map(int, input().split()) # n:세로 / m:가로
lst = [list(map(int, input().split())) for _ in range(n)]

#방향 설정, cctv타입설정, 감시, 개수찾기
# 왼 오 위 아
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cctv = []
type = {
    1: [[0], [1], [2], [3]],
    2: [[0, 1], [2, 3]],
    3: [[0, 2], [3, 2], [1, 3], [3, 1]],
    4: [[0, 1, 3], [0, 1, 2], [2, 3, 4], [0, 1, 2]],
    5: [[0, 1, 2, 3]]
}

def watch(x, y, type, temp):
    
    return

min_cnt = 0
zero_cnt = 0

