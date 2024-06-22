def solution(dots, lines):
    answer = 0
    d = []
    for i in range(len(dots)-1):
        d.append(dots[i+1] - dots[i])

    for i in range(len(d)):
        if d[i] == 1:
            d[i] = 0

    s = sum(d)

    for _ in range(len(lines)):
        if s <= 0:
            break
        l = lines.pop()
        s -= l
        answer += 1
    
    if s > 0:
        return -1
    else:
        return answer