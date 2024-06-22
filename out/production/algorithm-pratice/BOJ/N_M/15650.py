# n과 m(2)
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
num_lst = [i for i in range(n+1)]
# cnt = 1
def dfs(temp):
    # global cnt
    if len(temp) == m:
        print(*temp)
        return
    
    for i in range(1, n+1):
        # cnt += 1
        # print(f"cnt={cnt}, i={i}")
        if (i not in temp) and (len(temp) == 0 or i > temp[-1]):
            temp.append(num_lst[i])
            # print(f"i={i}, temp={temp}")
            dfs(temp)
            temp.pop()

dfs([])