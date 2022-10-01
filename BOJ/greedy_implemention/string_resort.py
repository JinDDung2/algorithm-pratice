# 1KA5CB7
# a = AJKDLSI412K4JSJ9D
from curses.ascii import isalpha


s = list(input())
sum = 0
# cnt = 0
# num = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
# for i in s:
#     if i in num:
#         sum += int(i)
#         cnt += 1

# lst = sorted(s)
# del lst[:cnt]
# lst.append(str(sum))
# print(''.join(lst))

result = []
for i in s:
    if i.isalpha():
        result.append(i)
    else:
        sum += int(i)
result.sort(key=lambda x:x)
result.append(str(sum))

print(''.join(result))