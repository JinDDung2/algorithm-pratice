# 등굣길

def solution(m, n, puddles):
    answer = 0
    way = [[0]* (m+1) for _ in range(n+1)]
    way[1][1] = 1
    for puddle in puddles:
        first = puddle[0]
        second = puddle[1]
        way[second][first] = -1
    # print(way)


    for i in range(1, n+1):
        for j in range(1, m+1):
            if way[i][j] == -1:
                way[i][j] = 0
                continue

            way[i][j] += (way[i-1][j] + way[i][j-1]) % 1000000007
            print(way)

    answer = way[n][m]
    return answer


m, n = 4, 3
puddles = [[2, 2]]
print(solution(m, n, puddles))