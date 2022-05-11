
n = 6
path = [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]
gates = [1, 3]
summits = [5]
answer = []
visit = []
p = 0


lst_time = [[0]*(n+1) for _ in range(n+1)]
lst_node = [[] for _ in range(n+1)]
for i in path:
    start = i[0]
    end = i[1]
    lst_time[start][end] = i[2]
    lst_time[end][start] = i[2]
    lst_node[start].append(end)
print(lst_time)
print(lst_node)

# for i in range(len(gates)):
#     visit.append(gates[i])
#     while True:

