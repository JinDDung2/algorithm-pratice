# n과 m(1)

n, m = map(int, input().split())
lst = []
def dfs():
    if len(lst) == m:
        print(' '.join(map(str, lst)))
        return
    
    for i in range(1, n+1):
        if i not in lst:
            lst.append(i)
            # print(f"i={i}, lst={lst}")
            dfs()
            lst.pop()


print(dfs())