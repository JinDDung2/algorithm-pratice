# 체육복


def solution(n, lost, reserve):
    answer = 0
    lost.sort()
    for i in range(1, n+1):
        if i not in lost:   # 갖고있는사람 추가
            answer += 1
        else:
            if i in reserve:    # 잃어버린사람 중 여유분 있는 사람, 여유분, 잃어버린것에서 제거
                answer +=1
                lost.remove(i)
                reserve.remove(i)
    
    
    for i in lost:  #잃어버린사람
        if i-1 in reserve: # 중에서 앞사람한테 빌리기, 여유분에서 제거
            answer += 1
            reserve.remove(i-1)
        elif i+1 in reserve:    #중에서 뒷사람한테 빌리기, 여유분에서 제거
            answer += 1
            reserve.remove(i+1)
        

    return answer


print(solution(5, [2,4], [3]))
print(solution(4, [2,3], [3,4]))
