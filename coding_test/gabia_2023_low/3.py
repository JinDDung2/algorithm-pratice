def solution(N, coffee_times):
    answer = []
    lst = []
    idx = N
    # (주문번호, 시간)
    for i in range(N):
        lst.append([i+1, coffee_times[i]])
    
    while lst:
        m = 10000
        # 최소 커피 시간 찾기
        for c in lst:
            if m > c[1]:
                m = c[1]
        
        # 최소 커피 시간 흐름
        for c in lst:
            c[1] -= m
        # 다된 커피 꺼내고 완료 순서에 넣기 + 새로운 커피 넣기
        for i in range(len(lst)):
            print(f"lst={lst}, i={i}")
            if lst[i][1] == 0:
                a = lst.pop(i)
                answer.append(a[0])
                if idx < len(coffee_times)-1:
                    lst.append([idx, coffee_times[idx]])
                    idx += 1

    return answer

print(solution(3, [4, 2, 2, 5, 3])) # [2, 3, 1, 5, 4]