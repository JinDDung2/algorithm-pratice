# [S5] 카우버거
import sys

input = sys.stdin.readline
buger, side, drink = map(int, input().split())
bugerList = list(map(int, input().split()))
sideList = list(map(int, input().split()))
drinkList = list(map(int, input().split()))

n = min(buger, side, drink)
bugerList.sort(reverse=True)
sideList.sort(reverse=True)
drinkList.sort(reverse=True)
result = 0

for i in range(n):
    result += (bugerList[i] + sideList[i] + drinkList[i]) // 10 * 9

result += (sum(bugerList[n:]) + sum(sideList[n:]) + sum(drinkList[n:]))
print(sum(bugerList) + sum(sideList) + sum(drinkList))
print(result)
