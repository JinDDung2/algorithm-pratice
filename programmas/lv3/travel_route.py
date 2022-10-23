# 여행 경로
from collections import defaultdict



# tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
# tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
tickets = [["ICN", "BOO"], ["ICN", "COO"], ["COO", "ICN"]]

def solution(tickets):
    graph = defaultdict(list)
    for (start, end) in tickets:
        graph[start] += [end]
    # print(graph)
    
    # 역순
    for i in graph.keys():
        graph[i].sort(reverse=True)
    
    stack = ["ICN"]
    answer = []
    print(graph)

    while stack:
        point = stack.pop()
        # 키 값에 없거나, 키값이 있는데 밸류값이 없을 때
        if point not in graph or len(graph[point]) == 0:
            answer.append(point)
            # print(f"1:{stack}, answer:{answer}")
        else:
            stack.append(point)
            stack.append(graph[point].pop())
            # print(f"2:{stack}, answer:{answer}")
    
    return answer[::-1]

    
print(solution(tickets))
    
# def solution(tickets):
#     answer = []
#     tickets.sort(key= lambda x:(x[1], x[0]))
#     for i, [start, end] in enumerate(tickets):
#         if start == "ICN":
#             first, seocnd = tickets.pop(i)
#             break

#     queue = deque([])
#     queue.append([first, seocnd])
#     answer.append(first)
#     answer.append(seocnd)
#     while queue:
#         print(queue)
#         start, end = queue.popleft()
#         for i, [begin, dest] in enumerate(tickets):
#             if end == begin:
#                 b, d = tickets.pop(i)
#                 queue.append([b, d])
#                 answer.append(d)
#                 break
#     return answer

