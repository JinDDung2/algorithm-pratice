# 타겟 넘버 
answer = 0

def solution(numbers, target):
    global answer
    dfs(0, 0, numbers, target)
    
    return answer

# 인덱스, 최대길이, 결과값, 타겟, 배열
def dfs(idx, result, numbers, target):
    global answer
    if idx == len(numbers):
        if result == target:
            answer += 1
        return
    
    dfs(idx+1, result+numbers[idx], numbers, target)
    dfs(idx+1, result-numbers[idx], numbers, target)


print(solution([1, 1, 1, 1, 1], 3))
