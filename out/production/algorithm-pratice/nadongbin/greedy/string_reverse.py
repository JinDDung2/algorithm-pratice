# 문자열 뒤집기

import sys
input = sys.stdin.readline

data = input().rstrip()
# group 개수 구하기는게 목적
# != 않을 때 까지 그룹임
cnt_0 = 0
cnt_1 = 0

if data[0] == '0': cnt_0 += 1
else: cnt_1 += 1

for i in range(1, len(data)):
    if data[i] != data[i-1]:
        if data[i] == '1':
            cnt_1 += 1
        else:
            cnt_0 += 1
        # print(f"i={i}, 0={cnt_0}, 1={cnt_1}")

print(min(cnt_0, cnt_1))

'''
n = input()

cnt_0 = 0
cnt_1 = 0

if n[0] == '1':
    cnt_0 += 1
else:
    cnt_1 += 1

for i in range(1, len(n)-1):
    if n[i] != n[i+1]:
        if n[i+1] == '1':
            cnt_0 += 1
        else:
            cnt_1 += 1

# print(f"0={cnt_0}, 1={cnt_1}")
print(min(cnt_0, cnt_1))
'''

# 0001100
