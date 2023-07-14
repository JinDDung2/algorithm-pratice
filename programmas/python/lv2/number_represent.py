# 숫자의 표현

# 약수의 개수로 접근
# 정확성: 45.8, 효율성: 20.8, 총점:66,7/100
def solution(n):
    answer = 0
    for i in range(1, n+1):
        if n % i == 0:
            answer += 1
    return answer

# n:2 --> 2 / cnt:1
# n:3 --> 1+2, 3 / cnt:2
# n:4 --> 4 / cnt:1
# n:5 --> 2+3,5 / cnt:2
# n:6 --> 1+2+3,6 / cnt:2
# n:7 --> 3+4,7 / cnt:2
# n:8 --> 8 / cnt:1
# n:9 --> 2+3+4,4+5,9 / cnt:3
# n:11 --> 5+6, 11 / cnt:2
# n:12 --> 12 / cnt:1
# n:13 --> 6+7, 13 / cnt:2
# n:14 --> 2+3+4+5 ,14 / cnt:2
# n:15 --> 1+2+3+4+5, 4+5+6, 7+8, 15 / cnt:4

# 약수의 개수 중 홀수만 추출
def solution2(n):
    answer = 0
    for i in range(1, n+1):
        if n % i == 0 and i % 2 != 0:
            answer += 1
    return answer

print(solution2(9))