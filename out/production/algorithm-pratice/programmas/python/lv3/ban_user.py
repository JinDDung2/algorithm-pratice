# 2019 카카오 개발자 겨울 인턴십 불량 사용자
import re
from itertools import permutations 
def solution(user_id, banned_id):
    # '.'은 모든 문자열 일치
    banned_id = [id.replace("*", ".") for id in banned_id]
    answer = []
    n = len(banned_id)
    for a in range(n):
        print(a)
    
    # 순열로 경우의수를 가져옴 -> 1.re.match 2.길이 같음 => 일치
    for i in permutations(user_id, n):
        lst = list(i)
        check = True
        for k in range(n):
            # print(k)
            if re.findall(banned_id[k], lst[k]) and len(lst[k]) == len(banned_id[k]):
                continue
            else:
                check = False
                break
        # True이면, 배열에 없으면 경우의수를 배열에 넣기
        if check:
            s_lst = sorted(lst)
            if s_lst not in answer:
                answer.append(s_lst)
    return answer

## 다른 풀이
from itertools import product

def check(str1, str2):
    if len(str1) != len(str2):
        return False
    for i in range(len(str1)):
        if str1[i] == "*":
            continue
        if str1[i] != str2[i]:
            return False
    return True

def a_solution(user_id, banned_id):
    answer = set()
    result = [[] for i in range(len(banned_id))]

    for i in range(len(banned_id)):
        for u in user_id:
            if check(banned_id[i], u):
                result[i].append(u)

    result = list(product(*result))
    for r in result:
        if len(set(r)) == len(banned_id):
            answer.add("".join(sorted(set(r))))

    return len(answer)