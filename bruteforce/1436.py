# 영화감독 숌
n = int(input())
number = '666'
result = 665
while n > 0:
    result += 1
    if number in str(result):
        n -= 1

print(result)

n = int(input())

count = 0
i = 665
while count < n:
    i += 1
    if '666' in str(i):
        count += 1

print(i)

