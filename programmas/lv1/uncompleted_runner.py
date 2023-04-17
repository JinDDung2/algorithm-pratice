# 코딩테스트 고득점 Kit [해쉬] 완주하지 못한 선수
def solution(participant, completion):
    dic = {}
    num = 0
    
    for player in participant:
        dic[hash(player)] = player
        num += hash(player)
        # print(dic.items())
    
    for complete in completion:
        num -= hash(complete)
        
    return dic[num]


p = ["marina", "josipa", "nikola", "vinko", "filipa"]
c = ["josipa", "filipa", "marina", "nikola"]
print(solution(p, c))

def solution2(participant, completion):
    player = {}
    num = 0
    
    for p in participant:
        player[hash(p)] = p
        num += hash(p)
    
    for c in completion:
        num -= hash(c)
    
    
    return player[num]