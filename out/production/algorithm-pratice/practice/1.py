def solution(survey, choices):
    answer = ""
    mbti = ["RT", "CF", "JM", "AN", "TR", "FC", "MJ", "NA"]
    choice = [-3, -2, -1, 0, 1, 2, 3]
    point = [0, 0, 0, 0]

    for i in range(len(survey)):
        p = choices[i]
        for j in range(len(mbti)):
            if j < 4:
                if survey[i] == mbti[j]:
                    point[j] += choice[p-1]

            if j >= 4:
                if survey[i] == mbti[j]:
                    point[j-4] -= choice[p-1]

    for i in range(4):
        if point[i] <= 0:
            answer += mbti[i][0]
        else:
            answer += mbti[i][1]

    return answer