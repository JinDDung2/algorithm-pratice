# 사탕게임

# 체크하는 로직, 바꾸는 로직 2개가 필요
# 개수 찾기 (행인접, 열인접)
def check(board):
    answer = 0

    for i in range(n):
        cnt = 1
        # 열인접
        for j in range(1, n):
            if board[i][j] == board[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            
            if cnt > answer:
                answer = cnt
            

        # 행인접
        cnt = 1
        for j in range(1, n):
            if board[j][i] == board[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            
            if cnt > answer:
                answer = cnt
            
    
    return answer

n = int(input()) # 50개 이하
board = [list(input()) for _ in range(n)]
answer = 0 # 최대 개수

# 위치바꾸기
# 리스트 계속복사하는 것 vs 원복해놓는것
for i in range(n):
    for j in range(n):
        # 열 바꾸기
        if j+1 < n:
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            temp = check(board)

            if answer < temp:
                answer = temp
            
            # 원복
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]

        # 행 바꾸기
        if i+1<n:
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            temp = check(board)

            if answer < temp:
                answer = temp

            # 원복
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]

        # print("i", i, ", j", j, "ans", temp)

print(answer)
    