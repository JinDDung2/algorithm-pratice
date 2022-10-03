def solution(nums):
    max_cnt = len(nums) / 2
    answer = len(set(nums))
    
    return min(max_cnt, answer)