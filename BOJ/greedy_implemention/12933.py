# [S3] 오리

import sys
input = sys.stdin.readline
S = input().rstrip()
lst = []
count = 0
# quack
quack = "quack"
# quack가 나온 적이 있으면 같은 오리
# quack가 나온 적이 없는데 q가 있으면 다른 오리
for s in S:
    if s == "q" and quack not in lst:
        lst.append("q")
    else: # u a c k 일 경우
        for i in range(len(lst)):
            if len(lst[i]) == 1:
                lst[i] += "u"
            elif len(lst[i]) == 2:
                lst[i] += "a"
            elif len(lst[i]) == 3:
                lst[i] += "c"
            elif len(lst[i]) == 4:
                lst[i] += "k"
print(lst)

for s in lst:
    if s == "quack":
        count += 1

if count == 0 or len(S) % 5 != 0:
    print(-1)
else:
    print(count)

