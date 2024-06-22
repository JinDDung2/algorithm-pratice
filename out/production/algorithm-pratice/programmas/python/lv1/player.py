# 완주하지 못한 선수

def solution(participant, completion):
    answer = ""
    num = 0
    dic = {}

    for player in participant:
        dic[hash(player)] = player
        num += int(hash(player)) 
        # print(hash(player))
    
    for success in completion:
        num -= hash(success)
    
    answer = dic[num]
    return answer

print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]))