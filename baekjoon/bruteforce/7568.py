# 덩치
n = int(input())
people = [list(map(int, input().split())) for _ in range(n)]
#  각각 비교해서 +1?
# 어차피 꺼낼걸 하나씩 꺼내자나. 개만 다른것들과 비교해서 등수 덩해줘
for i in people:
    rank = 1
    for j in people:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1

    print(rank, end=' ')

# rank = [1 for _ in range(n)]
# for i in range(n):
#     a = 1
#     for j in range(n):
#         if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
#             a += 1
#     rank[i] = a
# print(rank)

# ㅊ
n = input()
arr = []
for _ in range(int(n)):
    kg, cm = map(int, input().split())
    arr.append([kg, cm])

    

for i in range(len(arr)):
    rank = 1
    for j in range(len(arr)):
        if i == j:
            continue
        elif arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
            rank += 1
    print(rank, end=' ')


# ㅇㅎ

n = int(input())
dd = list()
for i in range(n):
    x,y = map(int, input().split())
    dd.append((x,y))

rank_list = []
for i in range(len(dd)):
    rank = len(dd) + 1
    std_w = dd[i][0]
    std_h = dd[i][1]
    for j in range(len(dd)):
        if not (std_w < dd[j][0] and std_h < dd[j][1]):
            rank -= 1
    rank_list.append(rank)
print(*rank_list)

