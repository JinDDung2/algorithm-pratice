# n과m (3)
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
num_lst = []

def dfs():
    if len(num_lst) == m:
        print(*num_lst)
        return

    for i in range(1, n+1):
        num_lst.append(i)
        dfs()
        num_lst.pop()

dfs()
