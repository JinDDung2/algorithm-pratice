# [S4] DNA

import sys
input = sys.stdin.readline

# 각 자리마다 가장 많이나오는 알파벳을 넣을 것
# 각 자리마다 알파벳 개수 구하고, N개에서 알파벳 개수 최댓값을 뺀 것이 각 자리 별 최솟값
N, M = map(int, input().split())
data = [input().rstrip() for _ in range(N)]
cnt = 0
result = ""
for i in range(M):
    # A C G T
    count_lst = [0] * 4
    for j in range(N):
        if data[j][i] == "A":
            count_lst[0] += 1
        elif data[j][i] == "C":
            count_lst[1] += 1
        elif data[j][i] == "G":
            count_lst[2] += 1
        elif data[j][i] == "T":
            count_lst[3] += 1
    idx = count_lst.index(max(count_lst))
    if idx == 0: result += "A"
    elif idx == 1: result += "C"
    elif idx == 2: result += "G"
    elif idx == 3: result += "T"
    cnt += N - max(count_lst)

print(result)
print(cnt)
