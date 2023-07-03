# 연산자 끼워 넣기
import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))
# + - * //
add, sub, mul, div = map(int, input().split())
max_num = -1e9
min_num = 1e9

def dfs(i, now):
    global min_num, max_num, add, sub, mul, div
    if i == N:
        min_num = min(min_num, now)
        max_num = max(max_num, now)
    else:
        if add > 0:
            add -= 1
            dfs(i+1, now + num[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i+1, now - num[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i+1, now * num[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i+1, now // num[i])
            div += 1

dfs(1, num[0])

print(max_num)
print(min_num)
print(add, sub, mul, div)


# test 1 - > 30 30
# 2
# 5 6
# 0 0 1 0
# test 2 -> 35 17
# 3
# 3 4 5
# 1 0 1 0
# test 3 -> 54 -24
# 6
# 1 2 3 4 5 6
# 2 1 1 1