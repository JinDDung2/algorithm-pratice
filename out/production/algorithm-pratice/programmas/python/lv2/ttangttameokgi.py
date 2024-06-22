# 땅따먹기 -> dp
def solution(land):
    # 100,000 * 4
    # 각 열의 최댓값과 최댓값을 갖는 인덱스 구하기
    # 이전 행에 있던 값들 중 열이 같은 값을 빼고 최댓값 더하기
    for i in range(1, len(land)):
        for j in range(len(land[i])):
            temp = land[i-1][j]
            land[i-1][j] = 0
            land[i][j] += max(land[i-1][0], land[i-1][1], land[i-1][2], land[i-1][3])
            land[i-1][j] = temp

    return max(land[-1])