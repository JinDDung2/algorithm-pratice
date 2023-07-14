# 코딩테스트 고득점 Kit [완전탐색] 최소직사각형
def solution(sizes):
    big = []
    small = []
    
    for size in sizes:
        if size[0] >= size[1]:
            big.append(size[0])
            small.append(size[1])
        else:
            big.append(size[1])
            small.append(size[0])
    
    big.sort()
    small.sort()
    
    return big[-1] * small[-1]