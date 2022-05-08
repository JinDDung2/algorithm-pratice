alp, cop = 0, 0
problems = [[0, 0, 2, 1, 2], [4, 5, 3, 1, 2], [4, 11, 4, 0, 2], [10, 4, 0, 4, 2]]
# 13


def solution(alp, cop, problems):
    answer = 0
    problems.sort(key=lambda x:(x[0]+x[1]))
    print(problems)

    for i in range(len(problems)):
        if i == 0:
            if problems[i][0] > alp:
                answer += problems[i][0] - alp
                alp = problems[i][0]
            elif problems[i][0] > cop:
                answer += problems[i][1] - cop
                cop = problems[i][1]
        
        if problems[i-1][2] > alp and problems[i-1][3] > cop and problems[i-1][2] != 0 and problems[i-1][3] != 0:
            a = (problems[i][0]-alp)//problems[i-1][2]
            c = (problems[i][1]-cop)//problems[i-1][3]
            n = min(a, c)
            alp += problems[i-1][2]*n
            cop += problems[i-1][3]*n
        elif problems[i-1][2] == 0:
            n = (problems[i][1]-cop)//problems[i-1][3]
            cop += problems[i-1][3]*n
        elif problems[i-1][3] == 0:
            n = (problems[i][0]-alp)//problems[i-1][2]
            alp += problems[i-1][2]*n
        
        answer += n*problems[i-1][4]
        print('ago', 'i', i, 'alp', alp, 'cop', cop, answer)

        if alp < problems[i][0]:
            answer += problems[i][0] - alp
            alp = problems[i][0]
        elif cop < problems[i][1]:
            answer += problems[i][1] - cop
            cop = problems[i][1]
        print('aft', 'i', i, 'alp', alp, 'cop', cop, answer)

    return answer


print(solution(alp, cop, problems))