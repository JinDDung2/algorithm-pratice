def solution(clothes):
    answer = 0
    dict = {}
    
    # key:종류 value:개수
    for cloth, type in clothes:
        dict[type] = dict.get(type, 0) +1
    # print(dict)

    answer = 1

    # 입지 않은 것도 고려
    for type in dict:    
        answer *= (dict[type]+1)

    # 아무것도 입지 않은 것은 제외
    return answer -1


c1 = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
c2 = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
print(solution(c2))