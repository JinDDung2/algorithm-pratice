# 쿼드압축 후 개수 세기 - 분할정복

def solution(arr):
    answer = [0, 0]
    n = len(arr)
    dfs(0, 0, n, arr, answer)
    return answer

def dfs(x, y, n, arr, answer):
    check = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if check != arr[i][j]:
                n //= 2
                dfs(x, y, n, arr, answer)
                dfs(x, y+n, n, arr, answer)
                dfs(x+n, y, n, arr, answer)
                dfs(x+n, y+n, n, arr, answer)
                return
    if check == 0:
        answer[0] += 1
    else:
        answer[1] += 1
