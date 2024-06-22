# 뱀
import sys
input = sys.stdin.readline
N = int(input())
K = int(input())
apple = [list(map(int, input().split())) for _ in range(K)]
L = int(int(input()))
info = []
for i in range(L):
    x, c = input().rstrip().split()
    info.append([int(x), c])
data = [[0] * (N+1) for _ in range(N+1)]
for a in apple:
    i, j = a[0], a[1]
    data[i][j] = 1

# 동 남 서 북
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def turn(direction, c):
    if c == 'L':
        direction = (direction-1) % 4
    else:
        direction = (direction+1) % 4
    
    return direction

def simulate():
    y, x = 1, 1 # 머리
    data[y][x] = 2 # 뱀이 존재하는 곳을 2로 둘 것임
    direction = 0
    time = 0
    idx = 0
    que = [[y, x]]
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]
        if 1 <= nx <= N and 1 <= ny <= N and data[ny][nx] != 2:
            # 사과 없는 경우 -> 꼬리제거
            if data[ny][nx] == 0:
                data[ny][nx] = 2
                que.append([ny, nx])
                px, py = que.pop(0)
                data[px][py] = 0
            # 사과 있는 경우 -> 머리만 이동
            if data[ny][nx] == 1:
                data[ny][nx] = 2
                que.append([ny, nx])
        # 벽, 몸통에 부딪힌 경우        
        else:
            time += 1
            break
        # 머리 이동
        y, x = ny, nx
        time += 1
        # 회전할 시간
        if idx < L and time == info[idx][0]:
            direction = turn(direction, info[idx][1])
            print(f"idx={idx}, time={time}, direction={direction}")
            idx += 1

    return time


print(simulate())

# test 1
# 6
# 3
# 3 4
# 2 5
# 5 3
# 3
# 3 D
# 15 L
# 17 D

# test 2
# 10
# 4
# 1 2
# 1 3
# 1 4
# 1 5
# 4
# 8 D
# 10 D
# 11 D
# 13 L