# [lv2] 삼각달팽이

def solution(n):
    lst = [[0] * n for _ in range(n)]
    
    x, y = -1, 0
    num = 1
    for i in range(n):
        for k in range(i, n):
            if i % 3 == 0:
                x += 1
            elif i % 3 == 1:
                y += 1
            elif i % 3 == 2:
                x -= 1
                y -= 1
            lst[x][y] = num
            num += 1
    
    answer = []
    for i in lst:
        for j in range(len(i)):
            if i[j]:
                answer.append(i[j])
    return answer

def fir_solution(n):
    answer = []
    lst = []
    for i in range(1, n+1):
        temp = [0] * i
        for j in range(i):
            temp[j] = 0
        lst.append(temp)
    
    lst[0][0] = 1
    for i in range(n):
        a = i % 3
        b = i // 3
        if a == 0:
            for k in range(n-1):
                if not lst[k+1][b]:
                    lst[k+1][b] = lst[k][b] + 1
        elif a == 1:
            for k in range(n-1):
                if not lst[-b][k+1]:
                    lst[-b][k+1] = lst[-b][k] + 1
        else:
            for k in range(n-1, 0, -1):
                if not lst[k-1][-b]:
                    lst[k-1][-b] = lst[k][-b] +1
        
    print(lst)
    return answer


print(solution(4))