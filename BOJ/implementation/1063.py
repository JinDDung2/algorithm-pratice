# [S3] 킹

import sys
input = sys.stdin.readline

king, stone, N = input().split()
king = list(map(int, [ord(king[0]) -64, king[1]]))
stone = list(map(int, [ord(stone[0]) -64, stone[1]]))
N = int(N)
chess = {"R": [1, 0], "L": [-1, 0], "B": [0, -1], "T": [0, 1], "RT": [1, 1], "LT": [-1, 1], "RB": [1, -1], "LB": [-1, -1]}

# 이동
for _ in range(N):
    move = input().rstrip()
    nx = king[0] + chess[move][0]
    ny = king[1] + chess[move][1]

    if 0<nx<=8 and 0<ny<=8:
        if nx == stone[0] and ny == stone[1]:
            sx = stone[0] + chess[move][0]
            sy = stone[1] + chess[move][1]
            if 0<sx<=8 and 0<sy<=8:
                king = [nx, ny]
                stone = [sx, sy]
        else:
            king = [nx, ny]

print(f"{chr(king[0] + 64)}{king[1]}")
print(f"{chr(stone[0] + 64)}{stone[1]}")