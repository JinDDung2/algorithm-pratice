# 평범한 배낭
# DP

# 4 7
# 6 13
# 4 8
# 3 6
# 5 12
import sys

n, k = map(int, sys.stdin.readline().split())    # n=개수 k=무게

bag = {0:0}     # 무게 : 가치
for _ in range(n):
    w, v = map(int, sys.stdin.readline().split())
    data = {}
    for bag_w, bag_v in bag.items():
        if bag_w + w <= k and bag_v + v > bag.get(bag_w + w, 0):
            data[bag_w+w] = bag_v+v
    bag.update(data)

# print(bag)
print(max(bag.values()))

