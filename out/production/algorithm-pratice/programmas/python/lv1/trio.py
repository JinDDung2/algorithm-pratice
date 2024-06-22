# 삼총사

def solution(number):
    answer = 0
    for i in range(len(number)-2):
        for j in range(i+1, len(number)-1):
            for k in range(j+1, len(number)):
                if number[i]+number[j]+number[k] == 0:
                    answer += 1

    return answer


number1 = [-2, 3, 0, 2, -5]
number2 = [-3, -2, -1, 0, 1, 2, 3]
number3 = [-1, 1, -1, 1]

print(f"1={solution(number1)}")
print(f"2={solution(number2)}")
print(f"3={solution(number3)}")