# [21년 재직자 대회 예선] 회의실 예약

import sys
input = sys.stdin.readline

# test 1
N, M = map(int, input().split())
rooms = dict()
for _ in range(N):
    room = input().rstrip()
    rooms[room] = []
for _ in range(M):
    name, start, end = input().rstrip().split()
    start, end = int(start), int(end)
    rooms.get(name).append([start, end])

def checkTime(lst):
    available = []
    check = 9

    # 이용 가능 시간
    for time in lst:
        if check < time[0]:
            available.append([check, time[0]])
        check = time[1]
    # 회의 마지막시간이 18시가 아닐 때
    if check != 18:
        available.append([check, 18])
    # available 비어 있다면 -> not
    if not available:
        print("Not available")
    # available 값이 있으면 출력
    else:
        print(f"{len(available)} available:")
        for s, e in available:
            s, e = str(s), str(e)
            if s == "9": s = "09"
            print(f"{s}-{e}")

for room in sorted(rooms):
    rooms[room].sort(key= lambda x:x[0])
    print(f"Room {room}:")
    checkTime(rooms[room])
    N -= 1
    if N:
        print("-----")

# test 2
'''
def checkTimes(times):
    available = []
    check = 9
    
    for time in times:
        start, end = time[0], time[1]
        if check < start:
            available.append([check, start])
        check = end

    if check != 18:
        available.append([check, 18])
    
    if not len(available):
        print("Not available")
    else:
        print(f"{len(available)} available:")
        for t in available:
            s, e = str(t[0]), str(t[1])
            if s == "9": s = "09"

            print(f"{s}-{e}")

N, M = map(int, input().split())
people = dict()

for _ in range(N):
    a = input().strip()
    people[a] = []

for _ in range(M):
    room, start, end = input().split()
    people[room].append([int(start), int(end)])

for room, times in sorted(people.items()):
    times.sort(key= lambda x:x[0])
    print(f"Room {room}:")
    checkTimes(times)
    N -= 1
    if N:
        print("-----")
'''