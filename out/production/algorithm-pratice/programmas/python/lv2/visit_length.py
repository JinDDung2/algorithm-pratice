def solution(dirs):
    answer = 0
    dict = {"U":[0, 1], "D":[0, -1], "R":[1, 0], "L":[-1,0]}
    s = set()

    cur_x, cur_y = (0, 0)
    for move in dirs:
        # {[지금, 지금, 다음, 다음]}
        next_x, next_y = cur_x + dict[move][0], cur_y + dict[move][1]
        if -5 <= next_x <= 5 and -5 <= next_y <= 5:
            s.add((cur_x, cur_y, next_x, next_y))
            s.add((next_x, next_y, cur_x, cur_y))
            cur_x, cur_y = next_x, next_y

    return len(s) / 2