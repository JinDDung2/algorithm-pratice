# 효율적인 화폐 만들기
# 최적 부분구조인가? O
# 중복되는 부분 구조인가? O
# bottomUp
n, m = map(int, input().split())
coin = list(map(int, input().split()))
d = [10001]* (m+1)
d[0] = 0


def dp():
    for i in range(n):
        d[coin[i]] = 1
        for j in range(coin[i], m+1):
            if d[j - coin[i]] != 10001:
                d[j] = min(d[j], d[j-coin[i]] + 1)
    
    if d[m] == 10001: 
        return -1
    else:
        return d[m]


print(dp())
