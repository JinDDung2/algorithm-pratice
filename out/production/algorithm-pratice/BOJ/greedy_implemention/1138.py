#한 줄로 서기

n = int(input())
people = list(map(int, input().split()))    # 나보다 큰 사람이 몇명있는지를 적어둔 것
ans = [0] * n

# 들어갈자리
for i in range(n):
    cnt = 0 # 나보다 큰 사람 수
    # 모든 사람과 비교
    for j in range(n):
        if cnt == people[i] and ans[j] == 0:
            ans[j] = i+1
            break

        elif (ans[j] == 0):
            cnt += 1
    # print(ans)

# print("final", ans)
print(*ans)
