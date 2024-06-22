# 수 찾기
def binary(x, start, end):
    if start > end:
        return 0
    
    mid = (start+end)//2

    if x == data_n[mid]:
        return 1
    elif x < data_n[mid]:
        return binary(x, start, mid-1)
    elif x > data_n[mid]:
        return binary(x, mid+1, end)

n = int(input())
data_n = sorted(list(map(int, input().split())))
m = int(input())
data_m = list(map(int, input().split()))

for x in data_m:
    start = 0
    end = n-1
    print(binary(x, start, end=' '))
