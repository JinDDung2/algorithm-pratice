# 동전 0
n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
coins.sort(reverse=True)
cnt = 0

for coin in coins:
    cnt += k // coin
    k %= coin

print(cnt)

# n , k = map(int, input().split())
# change = [int(input()) for _ in range(n)]
# lst = sorted(change,reverse=True)
# cnt = 0
# while k != 0:
#     for i in lst :
#         if k == k % i :
#             continue
#         else :
#             cnt += (k // i)
#             k = k % i
# print(cnt)