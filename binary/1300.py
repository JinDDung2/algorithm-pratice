# K번째 수
n = int(input())
k = int(input())

# 1 2 3                         1 2 3 4
# 2 4 6                         2 4 6 8
# 3 6 9                         3 6 9 12
# 1 2 2 3 3 4 6 6 9             4 8 12 16  --> 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16

def solution():
    start = 1
    end = k
    ans = 0

    while start<=end:
        mid = (start+end)//2
        cnt = 0
        for i in range(1, n+1):
            cnt += min(n, mid//i)
        # print('m', mid, 'cnt', cnt, 's', start, 'e', end)

        if cnt >= k:
            end = mid-1
            ans = mid
        else:
            start = mid+1
    
    return ans

print(solution())