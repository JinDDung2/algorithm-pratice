# 코딩테스트 고득점 Kit [정렬] H-Index
def solution(citations):
    citations_sort = sorted(citations)
    
    for idx, citation in enumerate(citations_sort):
        if citation >= len(citations_sort)-idx:
            answer = len(citations_sort)-idx
            break
    
    if sum(citations) == 0:
        answer = 0
    return answer

def try2(citations):
    answer = 0
    citations.sort()
    
    if sum(citations) == 0:
        return 0
    
    for idx, value in enumerate(citations):
        if value >= len(citations) - idx:
            answer = len(citations) - idx
            break
    return answer


citations = [3, 0, 6, 1, 5]
print(solution(citations))
