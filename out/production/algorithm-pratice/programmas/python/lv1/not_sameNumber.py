# 코딩테스트 고득점 Kit [스택/큐] 같은 숫자는 싫어
def solution(arr):
    answer = []
    answer.append(arr[0])
    
    for i in range(1, len(arr)):
        if arr[i] != answer[-1]: answer.append(arr[i]) 
    
    return answer