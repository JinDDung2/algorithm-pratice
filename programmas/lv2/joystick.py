# 코딩테스트 고득점 Kit [탐욕법] 조이스틱
def solution(name):
    answer = 0
    
    min_move = len(name) - 1
    
    for i, ch in enumerate(name):
        answer += min(ord(ch) - ord('A'), ord('Z') - ord(ch) + 1)
        
        next = i+1
        while (next < len(name) and name[next] == 'A'):
            next += 1
            
        # 기존, 연속된 A의 왼쪽시작 방식, 연속된 A의 오른쪽시작 방식 비교 및 갱신
        min_move = min([min_move, 2 * i + len(name) - next, i + 2 * (len(name) -next)])
        
    # 알파벳 변경(상하이동) 횟수에 좌우이동 횟수 추가
    answer += min_move
    return answer