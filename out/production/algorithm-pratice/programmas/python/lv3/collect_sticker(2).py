# Summer/Winter Coding(~2018) 스티커 모으기(2)
def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    # 규칙을 알려줘~~
    # 1번째 뜯을 경우 vs 안뜯을경우 -> 2개 필요
    dp1 = [0] * len(sticker)
    dp2 = [0] * len(sticker)
    
    dp1[0] = sticker[0]
    dp1[1] = sticker[0]
    # 1번째 뜯을경우
    for i in range(2, len(sticker)-1):
        dp1[i] = max(dp1[i-2] + sticker[i], dp1[i-1])
    
    # 1번째 안뜯을 경우
    for i in range(1, len(sticker)):
        dp2[i] = max(dp2[i-2] + sticker[i], dp2[i-1])
    
    # print(f"dp1={dp1}")
    # print(f"dp2={dp2}")
    # return max(dp1[-2], dp2[-1])
    return max(max(dp1), max(dp2))