# [lv2] 덧칠하기

def solution(n, m, section):
    answer = 1
    if m == 1:
        return len(section)
    
    idx = section.pop()
    
    while section:
        num = section.pop()
        if idx - (m-1) > num:
            answer += 1
            idx = num
        # print(f"section={section}, idx={idx}, num={num}")
        
        
            
        
    return answer