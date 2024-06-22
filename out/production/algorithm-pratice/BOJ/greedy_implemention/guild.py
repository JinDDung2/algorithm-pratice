# 5
# 2 3 1 2 2 --> 2
n = int(input())
fear = list(map(int, input().split()))
fear.sort(key=lambda x:x)

cnt = 0
members = 0

for i in fear:
    members += 1
    # print(members)
    if members >= i:
        cnt += 1
        members = 0
    
print(cnt) 