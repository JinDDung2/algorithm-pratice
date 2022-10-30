# 도둑질
# def solution(money):
#     dp = [0] * len(money)
#     visited = [True] * len(money)
#     # 방문하면 i-1, i+1 털지 못함
#     # 첫번째와 마지막집도 이웃??? ok
#     # 첫집을 무조건 터는 경우 vs 두번째집을 무조건 터는 경우

#     for i in range(len(money)-1):
#         if i == 0 :
#             max_num = max(money[-1], money[i], money[i+1])
#             max_index = money.index(max_num)
#             dp[max_index] = max_num
#             visited[-1], visited[i], visited[i+1] = False, False, False

#         if visited:
#             print(f"i={i}, visited={visited}, dp={dp}, ago")
#             max_num = max(money[i-1], money[i], money[i+1])
#             max_index = money.index(max_num)
#             dp[max_index] = max_num
#             visited[max_index-1], visited[i], visited[i+1] = False, False, False
#             print(f"i={i}, visited={visited}, dp={dp}, after")

#     answer = sum(dp)

#     return answer

def solution(money):
    # 방문하면 i-1, i+1 털지 못함 --> dp값 누적
    # 첫번째와 마지막집도 이웃??? ok
    # 첫집을 무조건 터는 경우
    dp1 = [0] * len(money)
    dp1[0] = moeny[0]
    dp1[1] = max(moeny[0], moeny[1])

    for i in range(2, len(money)-1):
        dp1[i] = max(dp1[i-1], dp1[i-2]+money[i])
        # print(f"dp1={dp1}")
    #두번째집을 무조건 터는 경우
    dp2 = [0] * len(money)
    dp2[1] = money[1]

    for i in range(2, len(money)):
        dp2[i] = max(dp2[i-1], dp2[i-2]+moeny[i])
        # print(f"dp2={dp2}")

    answer = max(max(dp1), max(dp2))

    return answer
        

moeny = [1, 2, 3, 1]
print(solution(moeny))