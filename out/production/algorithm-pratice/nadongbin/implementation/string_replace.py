# 문자열 재정렬

import sys
input = sys.stdin.readline

data = input().rstrip()

alpha = []
num = 0

for d in data:
    if d.isalpha():
        alpha.append(d)
    else:
        num += int(d)

alpha.sort()
alpha.append(str(num))
print(''.join(alpha))

# K1KA5CB7 -> ABCKK13
# AJKDLSI412K4JSJ9D -> ADDIJJJKKLSS20