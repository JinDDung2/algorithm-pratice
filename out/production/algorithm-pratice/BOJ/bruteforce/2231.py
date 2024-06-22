# 분해합
n = int(input())
result = []

for i in range(n):
    eg = [i]
    for j in str(i):
        eg.append(int(j))
    
    if sum(eg) == n:
        result.append(i)

if len(result) >= 1:
    print(min(result))
else:
    print(0)

#ㅇㅎ
# 분해합 생성자

n = int(input())
answer = 0
for i in range(n):
    p = 0
    for j in str(i):
        p += int(j)
    if p + i == n:
        answer = i
        break

print(answer)
