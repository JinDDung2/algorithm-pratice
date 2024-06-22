from collections import deque

def solution(N, coffee_times):
    w = len(coffee_times)
    answer = []
    # (주문번호, 시간)
    lst = []
    idx = 1
    d = []
    q = deque(coffee_times)

    for _ in range(N):
        t = q.popleft()
        lst.append([idx, t])
        idx += 1
    while len(answer) != len(coffee_times):
        m = 10000
        # 리스트 길이 N까지 값[주문번호, 시간] 넣기
        while q and len(lst) < N:
            t = q.popleft()
            lst.append([idx, t])
            idx += 1

        # 최소 커피 시간 찾기
        for i in range(len(lst)):
            if m > lst[i][1]:
                m = lst[i][1]
            
        # 최소 커피 시간 흐름
        for i in range(len(lst)):
            lst[i][1] -= m

        # 다 된 커피 꺼내고 완료 순서에 넣기
        for i in range(len(lst)):
            if lst[i][1] == 0:
                d.append(i)
                answer.append(lst[i][0])
            
        while d:
            num = d.pop()
            lst.pop(num)
    return answer

print(solution(3, [4, 2, 2, 5, 3])) # [2, 3, 1, 5, 4]