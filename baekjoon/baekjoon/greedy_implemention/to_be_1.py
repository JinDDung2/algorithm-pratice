import sys


n, k = map(int, sys.stdin.readline().split())
cnt = 0
while True:
    multiple = (n // k) * k
    cnt += (n - multiple)
    n = multiple
    # print('1', n, multiple, cnt)
    if n < k:
        break
    n //= k
    cnt += 1
    # print('2', n, multiple, cnt)

cnt += (n-1)
print(cnt)