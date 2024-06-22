n, m = map(int, input().split())
data = list(map(int, input().split()))
start = min(data)
end = max(data)
result = 0

while start <= end:
    rest = 0
    h = (start+end)//2
    for i in data:
        if i > h:
            rest += i-h
    
    if rest >= m:
        result = h
        start = h+1
    else:
        end = h-1

print(result)
