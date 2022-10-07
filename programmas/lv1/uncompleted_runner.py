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