# 소수찾기
from itertools import permutations

def solution(numbers):
    answer = []
    for i in range(1, len(numbers)+1):
        # 순열을 통해 list 생성
        lst = list(permutations(numbers, i))
        # print(lst)
        #lst안에 값들은 튜플로 되어 있음 [('1',), ('7',)] / [('1', '7'), ('7', '1')]
        for j in range(len(lst)):
            # 문자열로 합쳐준 후에 int로 변환
            num = int("".join(lst[j]))
            
            if is_prime(num):
                answer.append(num)
    
    # 중복제거
    answer = list(set(answer))
    
    return len(answer)

# 소수판별
def is_prime(n):
    if n == 0 or n == 1:
        return False
    # 시간복잡도를 조금이라도 올리기 위해 n**0.5 까지만 반복
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True


print(solution("011"))