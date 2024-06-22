# 연속된 부분 수열의 합

def solution(sequence, k):
    answer = []
    l = 0
    r = 0
    sum = sequence[0]
    while True:
        if sum == k:
            answer.append([l, r])
            
        if sum < k:
            r += 1
            if r >= len(sequence): break
            sum += sequence[r]
            
        else:
            sum -= sequence[l]
            if l >= len(sequence): break
            l += 1
        
    answer.sort(key= lambda x:(x[1]-x[0], x[0]))
    
    return answer[0]


def try1(sequence, k):
    answer = []
    l = 0
    r = 0
    sum = sequence[0]
    
    while True:
        if sum < k:
            r += 1
            if r >= len(sequence):
                break
            sum += sequence[r]
        else:
            sum -= sequence[l]
            if l >= len(sequence):
                break
            l += 1
        if sum == k:
            answer.append([l, r])
        
        answer.sort(key= lambda x:(x[1]-x[0], x[0]))
    return answer[0]