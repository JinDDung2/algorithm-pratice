# H-Index

def solution(citations):
    citations_sort = sorted(citations)
    
    for idx, citation in enumerate(citations_sort):
        if citation >= len(citations_sort)-idx:
            answer = len(citations_sort)-idx
            break
    
    if sum(citations) == 0:
        answer = 0
    return answer


citations = [3, 0, 6, 1, 5]
print(solution(citations))
