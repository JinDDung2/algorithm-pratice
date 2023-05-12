# [21년 재직자 대회 예선] 회의실 예약

import sys
input = sys.stdin.readline

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