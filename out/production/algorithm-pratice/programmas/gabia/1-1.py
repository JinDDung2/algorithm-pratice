def solution(K, user_scores):
    answer = 0
    page = []
    idx = 0
    while len(page) < K:
        n, s = user_scores[idx].split()
        if not page:
            for i in range(len(page)):
                if n == page[i][0]:
                    if int(s) > page[i][1]:
                        page[i][1] = int(s)
                    idx += 1
                else:
                    page.append([n, int(s)])
                    idx += 1
                    answer += 1
        print(page, idx)
    
    page.sort(key= lambda x:(-x[1]))

    for i in range(idx, len(user_scores)):
        n, s = user_scores[i].split()
        # print(f"n={n}, s={s}, answer={answer}")
        for j in range(len(page)):
            # 이름 같을 경우 + 점수가 이전보다 높음 -> 점수 바꿈
            if n == page[j][0] and int(s) >= page[j][1]:
                page[j][1] = int(s)
                page.sort(key= lambda x:(-x[1]))
                # 순위 변동이 있으면 answewr += 1
                for k in range(len(page)):
                    if page[k][0] == n and k == j:
                        answer == 1
            
        # 꼴찌보다 점수 높으면 입성
        if int(s) > page[-1][1]:
            page.pop()
            page.append([n, int(s)])
            page.sort(key= lambda x:(-x[1]))
            answer += 1

        
    return answer

print(solution(3, ["a 100", "b 200", "a 200", "b 150", "c 50", "c 200"]))