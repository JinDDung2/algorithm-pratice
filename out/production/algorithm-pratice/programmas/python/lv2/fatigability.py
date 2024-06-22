# 코딩테스트 고득점 Kit [완전탐색] 피로도
from itertools import permutations

def solution(k, dungeons):
    answer = -1
    dungeon_cnt = len(dungeons)
    
    # 순열을 통해 모든 경우의 수 확인
    for dungeon in permutations(dungeons, dungeon_cnt):
        power = k
        cnt = 0
        #순열을 통해 나온 던전 챌린지 시작
        for go in dungeon:
            if power >= go[0]:
                power -= go[1]
                cnt += 1
            # 지금까지의 cnt와 보다 큰 cnt가 나오면 재할당
            if answer < cnt:
                answer = cnt

def try2(k, dungeons):
    answer = -1
    for d in permutations(dungeons, len(dungeons)):
        p = k
        cnt = 0
        for game in d:
            if p >= game[0]:
                p -= game[1]
                cnt += 1
        
        if answer < cnt:
            answer = cnt
    
    return answer

                
    return answer