# 가장 긴 증가하는 부분 수열 2
import sys
from bisect import bisect_left


n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
lst = [a[0]]

for i in a:
    if lst[-1] < i:
        lst.append(i)
    else:
        idx = bisect_left(lst, i)
        lst[idx] = i
    
print(len(lst))
