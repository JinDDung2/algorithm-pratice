# 1로 만들기
# 최적 부분구조인가? O
# 중복되는 부분 구조인가? O
# bottomUp

n = int(input())
d = [0] * 30001

def dynamic():
    for i in range(2, n+1):
        d[i] = d[i-1] + 1 
        if i % 2 == 0:
            d[i] = min(d[i], d[i//2]+1)
        if i % 3 == 0:
            d[i] = min(d[i], d[i//3]+1)
        if i % 5 == 0:
            d[i] = min(d[i], d[i//5]+1)
        # print(i, d)

    return d[n]


print(dynamic())