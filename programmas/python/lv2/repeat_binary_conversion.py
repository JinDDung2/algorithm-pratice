# 이진 변환 반복하기

def solution(s):
    answer = [0, 0]

    total_cnt = 0
    remove_cnt = 0

    while s != "1":
        cnt_0 = 0
        for i in s:
            if i == "0":
                cnt_0 += 1
        
        remove_cnt += cnt_0
        total_cnt += 1

        s = format(len(s)-cnt_0, 'b')
        # print(f"s={s}")
    
    answer[0], answer[1] = total_cnt, remove_cnt

    return answer


s1 = "110010101001"
s2 = "01110"
s3 = "1111111"
print(solution(s1))