# 점프와 텔레포트
def solution(n):
    ans = 0
    idx = 5
    # 5 ! 4 2 1 ! 0 --> 2
    # 6 3 ! 2 1 ! 0 --> 2
    # 5000 2500 1250 625! 624 312 156 78 39! 38 19! 18 9! 8 4 2 1!0 --> 2
    while (n != 0):
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            ans += 1
        
    return ans