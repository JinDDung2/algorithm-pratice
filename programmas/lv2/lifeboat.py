# 구명보트 
# 정확성 75/75 | 효율성 20/25
def solution(people, limit):
    answer = 0
    people.sort()
    while len(people)>1:
        if (people[-1] + people[0]) <= limit:
            people.pop()
            del people[0]
        else:
            people.pop()
        answer += 1
    if len(people) != 0:
        answer += 1
    return answer

# 투 포인트 사용
def solution(people, limit):
    two = 0
    people.sort()
    a = 0
    b = len(people)-1
    while a < b:
        if(people[a]+people[b]) <= limit:
            a += 1
            two += 1
        b -= 1
        # print(f"a={a}, b={b}")
    return len(people) - two