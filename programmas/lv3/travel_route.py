# 여행 경로
from collections import deque


ticket = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
answer = []
ticket.sort(key= lambda x:(x[1], x[0]))
for i, [start, end] in enumerate(ticket):
    if start == "ICN":
        first, seocnd = ticket.pop(i)
        break

queue = deque([])
queue.append([first, seocnd])
answer.append(first)
answer.append(seocnd)
while queue:
    start, end = queue.popleft()
    for i, [begin, dest] in enumerate(ticket):
        if end == begin:
            b, d = ticket.pop(i)
            queue.append([b, d])
            answer.append(d)
            break


print(answer)