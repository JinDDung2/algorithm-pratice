# n과 m(4)
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
temp = []
def backtracking(idx):
    if len(temp) == m:
        print(*temp)
        return
    
    for i in range(idx, n+1):
        temp.append(i)
        # print(f"idx={idx}, i={i}, temp={temp}")
        backtracking(i)
        temp.pop()

backtracking(1)