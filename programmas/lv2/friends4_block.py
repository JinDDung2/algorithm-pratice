# 2018 KAKAO BLIND RECRUITMENT[1차] 프렌즈4블록
def solution(m, n, board):
    for i in range(m):
        board[i] = list(board[i])
    
    cnt = 0
    rm = set()
    while True:
        # 보드를 순회하며 4블록이 된 곳의 좌표를 집합에 기록
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] == []:
                    continue
                if board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1]:
                    rm.add((i,j))
                    rm.add((i+1,j))
                    rm.add((i,j+1))
                    rm.add((i+1,j+1))
        
        # 좌표가 존재한다면 집합의 길이만큼 세주고 블록을 지움 
        if rm:
            cnt += len(rm)
            for i,j in rm:
                board[i][j] = []
            rm = set()
        # 없다면 함수 종료
        else:
            return cnt
        
        # 블록을 위에서 아래로 당겨줌
        while True:
            moved = False
            for i in range(m-1):
                for j in range(n):
                    if board[i][j] and board[i+1][j]==[]:
                        board[i+1][j] = board[i][j]
                        board[i][j] = []
                        moved = True
            if not moved:
                break
# -------
def incorr_solution(m, n, board):
    answer = 0
    same = dict()
    # 2x2 같은거 개수 찾기 -> 겹치는건 어떻게 파악해야할까
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j] == board[i][j+1] and board[i][j] == board[i+1][j] and board[i+1][j] == board[i+1][j+1]:
                same[(i, j)] = board[i][j]
                same[(i, j+1)] = board[i][j]
                same[(i+1, j)] = board[i][j]
                same[(i+1, j+1)] = board[i][j]
    
    answer += len(same)
    new_board = []
    
    # 겹치는 부분 0으로 만들기
    for i in range(m):
        temp = ""
        for j in range(n):
            if (i, j) not in same:
                temp += board[i][j]
            else:
                temp += "0"
        new_board.append(temp)
    
    for i in range(m):
        new_board[i] = list(new_board[i])
    # 위에서부터 내리기
    while True:
        moved = 0
        for i in range(m-1):
            for j in range(n):
                if new_board[i][j] != "0" and new_board[i+1][j] == "0":
                    new_board[i+1][j] = new_board[i][j]
                    new_board[i][j] = "0"
                    moved = 1
        if moved == 0:
            break
    
    same = dict()
    # 한번 더 찾기
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j] == new_board[i][j+1] and new_board[i][j] == new_board[i+1][j] and new_board[i+1][j] == new_board[i+1][j+1]:
                same[(i, j)] = new_board[i][j]
                same[(i, j+1)] = new_board[i][j]
                same[(i+1, j)] = new_board[i][j]
                same[(i+1, j+1)] = new_board[i][j]
    
    answer += len(same)
    
    return answer