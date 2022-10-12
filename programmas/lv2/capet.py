# 카펫

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