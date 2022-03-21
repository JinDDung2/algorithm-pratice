# # 블랙잭
# import itertools


# n, k = map(int, input().split())
# cards = list(map(int, input().split()))
# result = list(itertools.combinations(cards, 3))
# max = sum(min(list(result)))

# for i in result:
#     if sum(list(i)) < k and max < sum(list(i)):
#         max = sum(list(i))

# print(max)

n, m = map(int, input().split())
cards = list(map(int, input().split()))
result = []

for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            if cards[i]+cards[j]+cards[k] <= m:
                result.append(cards[i]+cards[j]+cards[k])

print(max(result))