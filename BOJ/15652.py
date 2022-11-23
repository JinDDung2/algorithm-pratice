# N과 M(4)

# (1 ≤ M ≤ N ≤ 8)
n, m = map(int, input().split())
# print(n, m)
lst = [] # 

def dfs(idx):
    if len(lst) == m:
        print(' '.join(map(str, lst)))
        return
    
    for i in range(idx, n+1):
        lst.append(i)
        # print(f"!1, i={i}, lst={lst}")
        dfs(i)
        lst.pop()

print(dfs(1))
