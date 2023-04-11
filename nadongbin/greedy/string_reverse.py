# 문자열 뒤집기
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

# 0001100
