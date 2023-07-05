# [S3] 펠린드롬 만들기

import sys
input = sys.stdin.readline
S = input().rstrip()
ch = dict()

for s in S:
    ch[s] = ch.get(s, 0) + 1

# 홀수 -> 알파벳 개수 홀수인거 1개여야함 -> 홀수 먼저 붙이고 짝수 붙여
# 짝수 -> 알파벳 개수 홀수이면 불가 -> 갯수 나눠서 붙여
# 사전순 -> 사전역순으로 배열해서 먼저 넣어
ch_sort = sorted(ch.keys(), reverse=True)
temp = ""
# 길이가 홀수이고, 1개만 있는 것은 가운데에
for key in ch_sort:
    if ch[key] % 2 == 1:
        if temp == "":
            temp += key
            ch[key] -= 1
        else:
            temp = "I'm Sorry Hansoo"

if temp != "I'm Sorry Hansoo":
    for key in ch_sort:
        if ch[key] % 2 == 0:
            cnt = ch[key] // 2
            temp = (key * cnt) + temp + (key * cnt)

print(temp)