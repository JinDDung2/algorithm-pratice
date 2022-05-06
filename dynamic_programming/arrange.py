# 병사 배치하기
# 가장 긴 증가하는 부분수열
n = int(input())
power = list(map(int, input().split()))

power.reverse()
dp = [1] * n
# dp = [power[0]]

# for i in power:
#     if dp[-1] > i:
#         dp.append(i)

# print(dp)


for i in range(1, n):
    for j in range(0, i):
        if power[j] < power[i]:
            dp[i] = max(dp[i], dp[j]+1)

print(n - max(dp)) 
print(dp)
