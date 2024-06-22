# 튜플

def solution(s):
    answer = []
    
    s = s[2:-2]
    lst = s.split("},{")
    
    result = []
    for i in lst:
        result.append(i.split(","))
    
    # print(result)
    
    result.sort(key = lambda x:len(x))
    # print(result)
    
    for i in result:
        for j in i:
            if int(j) not in answer:
                answer.append(int(j))
                break
        
    return answer