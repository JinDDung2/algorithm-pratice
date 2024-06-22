# 귤 고르기

def solution(k, tangerine):
    answer = 0
    dict = {}
    for size in tangerine:
        dict[size] = dict.get(size, 0) + 1
    
    sort_dict = sorted(dict.items(), key=lambda item:item[1], reverse=True)
    
    while k > 0:
        k -= sort_dict[answer][1]
        answer += 1
    return answer