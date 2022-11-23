# N과 M(4)

# (1 ≤ M ≤ N ≤ 8)
n, m = map(int, input().split())
# print(n, m)
lst = [] # 중복순열을 담을 값(계속 변할거임)

def dfs(idx): # 앞의 숫자와 비교해야하므로 파라미터로 넘겨줌
    if len(lst) == m: # 리스트 길이가 m과 같을 경우 출력
        print(' '.join(map(str, lst)))
        return
    
    for i in range(idx, n+1): # idx이상 n이하의 수를 반복
        lst.append(i) # 수를 더해주고
        # print(f"!1, i={i}, lst={lst}")
        dfs(i) # 더한 수로 재귀
        lst.pop() # 원상복구를 위해 pop

print(dfs(1))
