# [S5] 셀프 넘버

def check(n):
    num = n
    s = str(n)
    for i in range(len(s)):
        num += int(s[i])
        # print(f"s={s}, s[i]={s[i]} n={n}, num={num}")
    return num

num_set = set()
for i in range(1, 10001):
    a=check(i)
    num_set.add(a)

for i in range(1, 10001):
    if i not in num_set:
        print(i)