# ATM
n = int(input())
time = list(map(int, input().split()))

reuslt = 0
result_list = []
time.sort()
for i in time:
    reuslt += i
    result_list.append(reuslt)

print(result_list)
print(sum(result_list))

#충연
n = int(input())
data = sorted(list(map(int, input().split())))
answer = 0
for i in range(1, len(data)+1):
    j = 0
    time = 0
    while j < i:
        time += data[j]
        j += 1
    answer += time
    print(answer)
print(answer)

#인한
n = int(input())
time = list(map(int, input().split()))

time.sort(key= lambda x : x)
s = 0
for i in range(len(time)):
    s += sum(time[:i+1])
print(s)