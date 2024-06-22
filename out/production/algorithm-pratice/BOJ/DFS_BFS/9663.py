# [G4] N-Queen

import sys
input = sys.stdin.readline

N = int(input())
data = [0] * N
count = 0

def nqueen(idx):
    global count
    if idx == N:
        count += 1
        return
    
    for i in range(N):
        data[idx] = i
        if promising(idx):
            nqueen(idx+1)

# 같은열 x, 대각선 x
def promising(idx):
    for i in range(idx):
        if data[idx] == data[i] or (idx-i) == abs(data[idx] - data[i]):
            return False
    return True

nqueen(0)
print(count)