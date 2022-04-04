from bisect import bisect_right, bisect_left


n, x = map(int, input().split())
data = list(map(int, input().split()))

start_index = bisect_left(data, x)
end_index = bisect_right(data, x)
result = end_index-start_index
if result == 0:
    print(-1)
else:
    print(result)
