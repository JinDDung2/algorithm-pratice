# 1이 될 때 까지
X = int(input())

d = [0] * 30001

# 연산 횟수 구하기!!
for i in range(2, X+1):
    # 이전 값에 1을 더한 것. 이것과 다른 것들을 비교
    d[i] = d[i-1]+1
    # 2로 나누어 질 때
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2]+1)
    # 3으로 나누어 질 때
    elif i % 3 == 0:
        d[i] = min(d[i], d[i//3]+1)
    # 5로 나누어 질 때
    elif i % 5 == 0:
        d[i] = min(d[i], d[i//5]+1)
