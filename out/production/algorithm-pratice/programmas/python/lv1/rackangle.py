# 최소 직사각형

def solution(sizes):
    high = []
    low = []

    for size in sizes:
        if size[0] > size[1]:
            high.append(size[0])
            low.append(size[1])
        else:
            high.append(size[1])
            low.append(size[0])
    return max(high) * max(low)


print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))
print(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]))
print(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]))