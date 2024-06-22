# 행렬 테두리 회전하기

def solution(rows, columns, queries):
    answer = []
    lst = [[0] * (columns+1) for _ in range(rows+1)]
    
    num = 1
    for i in range(1, rows+1):
        for j in range(1, columns+1):
            lst[i][j] = num
            num += 1
            
    for x1, y1, x2, y2 in queries:
        temp = lst[x1][y1]
        m = temp
        # 왼쪽 k,y1
        for k in range(x1, x2):
            m = min(m, lst[k+1][y1])
            lst[k][y1] = lst[k+1][y1]
        # 아래 x2,k
        for k in range(y1, y2):
            m = min(m, lst[x2][k+1])
            lst[x2][k] = lst[x2][k+1]
        # 오른쪽 k, y2
        for k in range(x2, x1, -1):
            m = min(m, lst[k-1][y2])
            lst[k][y2] = lst[k-1][y2]
        # 위 x1, k
        for k in range(y2, y1, -1):
            m = min(m, lst[x1][k-1])
            lst[x1][k] = lst[x1][k-1]
        
        lst[x1][y1+1] = temp
        answer.append(m)
        # print(f"temp={temp}, lst={lst}")
            
    return answer