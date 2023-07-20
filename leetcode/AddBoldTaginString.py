# 616. Add Bold Tag in String

def solution(s: str, dict: list):
    visited = [False] * len(s)
    pre = '<b>'
    suf = '</b>'

    for d in dict:
        for j in range(len(s) - len(d)+1):
            if d == s[j:j+len(d)]:
                # print(f"d={d}, s={s[j:j+len(d)]}")
                for k in range(j, j+len(d)):
                    visited[k] = True
    
    tempT = ''
    tempF = ''
    result = []
    for i in range(len(s)):
        if visited[i]:
            if tempF:
                result.append(tempF)
                tempF = ''
            tempT += s[i]
        else:
            if tempT:
                tempT = pre + tempT + suf
                result.append(tempT)
                tempT = ''
            tempF += s[i]
    
    if tempT:
        tempT = pre + tempT + suf
        result.append(tempT)
    if tempF:
        result.append(tempF)
    
    return ''.join(result)
                    

print(solution("abcxyz123", ["abc", "123"]))
print(solution("abcxyz123", ["abc", "xyz"]))
print(solution("aaabbcc", ["aaa", "aab", "bc"]))
print(solution("aaabbccaabc", ["aaa", "aab", "bc"]))