# 코딩테스트 고득점 Kit [완전탐색] 카펫

def solution(brown, yellow):
    answer = []
    # brown 가로 >= yellow 가로+2
    # brown 세로 >= yellow 세로+2
    total = brown + yellow
    for height in range(1, total+1):
        if (total / height) % 1 == 0:
            width = total / height
            if width >= height:
                if 2*width + 2*height == brown+4:
                    answer = [width, height]
    return answer

def try2(brown, yellow):
    answer = []
    
    total = brown + yellow

    for y in range(1, total+1):
        if (total / y) % 1 == 0:
            b = total / y
            if b >= y:
                if brown == 2 * (b+y-2):
                    answer = [b, y]
                    
    return answer