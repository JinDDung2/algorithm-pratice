# 주유소

n = int(input())
meter = list(map(int, input().split()))
priceList = list(map(int, input().split()))

min_price = priceList[0]
money = meter[0] * priceList[0]

for i in range(1, n-1):
    if min_price > priceList[i]:
        min_price = priceList[i]
    money += min_price * meter[i]

print(money)

# min_p = price[0]
# total_price = 0
# total_far = 0

# for i in range(len(price) - 1):
#     if min_p > price[i]:
#         min_p = price[i]
# for v in k:
#     total_far += v

# for j in range(len(k)):
#     if price[j] != min_p:
#         total_price += k[j] * price[j]
#         total_far -= k[j]
#     else:
#         total_price += total_far * price[j]
#         break