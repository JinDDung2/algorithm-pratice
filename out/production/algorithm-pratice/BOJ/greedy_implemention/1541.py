# 잃어버린 괄호
n = input().split('-')
plus = list(map(int, (n[0].split('+'))))
minus = 0
for i in n[1:]:
    for j in i.split('+'):
        minus += int(j)

print(sum(plus)-minus)

# ㅊ
n = input()
num = ''
answer = 0
for i in n:
    if i != '-' and i != '+':
        num += i
    elif i == '-':
        answer += int(num)
        num = '-'
    elif i == '+' and num[0] == '-':
        answer += int(num)
        num = '-'
    elif i == '+' and num[0] != '-':
        answer += int(num)
        num = ''
answer += int(num)
print(answer)

#ㅇㅎ
# 세준이 새끼
sic = input().split("-")
# print(sic)
hap = 0

for i in sic[0].split("+"):
    hap += int(i)
for j in sic[1:]:
    for u in j.split("+"):
        hap -= int(u)
print(hap)