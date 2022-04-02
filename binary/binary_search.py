def binary1(start, end, arr, target):
    if start > end:
        return None
    
    mid = (start+end)//2

    if arr[mid] == target:
        return mid

    elif arr[mid] > target:
        return binary1(start, mid-1, arr, target)
    else:
        return binary1(mid+1, end, arr, target)


def binary2(start, end, arr ,target):
    while start <= end:
        mid = (start+end)//2

        if arr[mid] == target:
            return mid
        
        elif arr[mid] > target:
            end = mid-1
        elif arr[mid] < target:
            start = mid+1
        
        
n, target = map(int, input().split())
arr = list(map(int, input().split()))
# n, target = 10, 7
# arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
# arr = [1, 3, 5, 6, 9, 11, 13, 15, 17, 19]

# result = binary1(0, n-1, arr, target)
result = binary2(0, n-1, arr, target)

if result == None:
    print("fuck")
else:
    print(result+1)
