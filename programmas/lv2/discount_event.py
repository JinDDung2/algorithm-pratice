def solution(want, number, discount):
    answer = 0
    
    wish = {}
    now = {} # 10일 동안 가지고 올 수 있는 상품들
    
    # 딕셔너리 만들기
    for i in range(len(want)):
        wish[want[i]] = number[i]
        now[want[i]] = 0
    
    
    for i in range(len(discount)):
        # 10일전 으로 시작
        before = i - 10
        if before >= 0 and discount[before] in want:
            # 10일이 지난 물품의 개수는 삭제
            if now[discount[before]] > 0:
                now[discount[before]] -= 1
        
        # 내가 갖고 싶은 물건이면 수량 증가
        if discount[i] in want:
            now[discount[i]] += 1
        
        is_buy = True
        for key in wish.keys():
            if wish[key] > now[key]:
                is_buy = False
                break
        if is_buy:
            answer += 1
    return answer