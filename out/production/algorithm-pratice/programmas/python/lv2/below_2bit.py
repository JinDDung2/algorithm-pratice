# 월간 코드 챌린지 시즌2 2개 이하로 다른 비트

# 짝수값의 비트는 뒤에 0으로 끝나기 때문에 맨 뒤의 0을 1로만 바꾸면 됨
# 홀수갑의 비트는 편의상 맨 앞에 0을 추가 -> 맨 뒤의 인덱스부터 value가 0인 것을 찾음 -> 찾은 인덱스의 value 0을 1로 바꿈 + 찾은 인덱스의 다음 인덱스의 value 1을 0으로 바꿈
def solution(numbers):
    answer = []
    for num in numbers:
        # 짝수는 뒤에 0으로 끝남. 마지막에 0을 1로 바꾼다는것 -> 그냥 값의 +1
        if num % 2 == 0:
            answer.append(num+1)
            continue
        
        num_bin = '0' + bin(num)[2:]
        # 오른쪽부터 인덱스의 value값을 0인 값을 찾아서 1로 바꾸고
        idx = num_bin.rfind('0')
        num_bin = list(num_bin)
        # 그 인덱스+1의 value를 0->1
        num_bin[idx] = '1'
        num_bin[idx+1] = '0'
        answer.append(int(''.join(num_bin), 2))
                    
    return answer