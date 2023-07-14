# [lv2] 호텔 대실

def solution(book_time):
    data = [0 for _ in range(60 * 24)]
    for start, end in book_time:
        start = changeTime(start)
        end = changeTime(end) + 10

        if end > 60 * 24 - 1:
            end = 60 * 24 - 1

        for i in range(start, end):
            data[i] += 1
    return max(data)

def solution(book_time):
    answer = 0
    book_times = sorted([[changeTime(i[0]), changeTime(i[1])+10] for i in book_time])

    rooms = []
    for b in book_times:
        if not rooms:
            rooms.append(b)
            continue
        for i in range(len(rooms)):
            if b[0] >= rooms[i][1]:
                rooms[i][1] = b[1]
                break
        else:
            rooms.append(b)
    return len(rooms)

def changeTime(time):
    return int(time[:2]) * 60 + int(time[3:])