import sys
input = sys.stdin.readline
N, M = map(int, input().split())
lst = list(map(int, input().split()))

lst.sort()
print(lst)

h = 0
def binary(start, end, lst, M):
    while start <= end:
        rest = 0
        h = (start+end) // 2
        # print(f"start={start}, end={end}, h={h}")

        for t in lst:
            if t > h:
                rest += (t - h)
        
        if rest == M:
            break
        elif rest > M:
            start = h + 1
        else:
            end = h - 1
    
    return h

print(binary(0, lst[-1], lst, M))
# 4 6
# 19 15 10 17