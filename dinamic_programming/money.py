n, m = map(int, input().split())
coin = list(map(int, input().split()))
d = [10001]* m
d[0] = 0


def dp():
    for i in range(n):
        for j in range(coin[i], m+1):
            if d[j - coin[i]] != 10001:
                d[j] = min(d[j], d[j-coin[i]] + 1)
    
    if d[m] == 10001:
        return -1
    else:
        return d[m]

print(dp())

