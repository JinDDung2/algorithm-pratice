# 2021 카카오 채용연계형 인턴십 거리두기 확인하기
from collections import deque

dr = [-1, 1, 0, 0] # 좌우
dc = [0, 0, -1, 1] # 상하

def bfs(p, row, col):
    visited = [[False] * 5 for _ in range(5)]
    q = deque()
    visited[row][col] = True
    
    # 행, 열, 거리
    q.append([row, col, 0])
    
    while q:
        r, c, d = q.popleft()
        
        if d > 2:
            continue
        # 시작 위치를 만날 수도 있기 때문에 d = 0 은 제외
        if d != 0 and p[r][c] == 'P':
            # print(f"p={p}, r={r}, c={c}, d={d}")
            return False
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            
            if nr < 0 or nr >= 5 or nc < 0 or nc >= 5:
                continue
            if visited[nr][nc]:
                # print(f"nr={nr}, nc={nc}")
                continue
            if p[nr][nc] == 'X':
                continue
            visited[nr][nc] = True
            q.append([nr, nc, d+1])
    return True

def check(p):
    for i in range(5):
        for j in range(5):
            if p[i][j] == 'P':
                if not bfs(p, i, j):
                    return 0
    return 1

def solution(places):
    answer = []
    
    for p in places:
        answer.append(check(p))
    return answer
