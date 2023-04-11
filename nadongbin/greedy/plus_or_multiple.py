# 더하기 혹은 곱하기

n = input()
data = [int(num) for num in n]
data.sort(reverse=True)
result = 1

if data[0] == 0:
    result = 0

for num in data:
    if num == 0:
        continue
    if num == 1:
        result += num
    else:
        result *= num

print(result)
# 02984