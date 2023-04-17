# 코딩테스트 고득점 Kit [해시] 폰켓몬
def solution(nums):
    max_cnt = len(nums) / 2
    cnt = len(set(nums))
    
    return min(max_cnt, cnt)

def solution2(nums):
    max_num = len(nums) // 2
    set_nums = set(nums)
    check_num = len(set_nums)
    return min(max_num, check_num)