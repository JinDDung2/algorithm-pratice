#숫자 카드 2
from bisect import bisect_left, bisect_right


def binary(x):
    start = bisect_left(data_n, x)
    end = bisect_right(data_n, x)

    return end - start

n = int(input())
data_n = sorted(list(map(int, input().split())))
m = int(input())
data_m = list(map(int, input().split()))
for x in data_m:
    print(binary(x), end= ' ')
