# 숫자 문자열과 영단어
def solution(s):

    dict = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4", "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}
    number = "0123456789"
    temp = ""
    answer = ""
    
    for i in range(len(s)):
        if s[i] in number:
            answer += s[i]
        else:
            temp += s[i]
            # print(f"i={i}, temp={temp}")
            if temp in dict:
                answer += dict[temp]
                temp = ""

    return int(answer)


s1 = "one4seveneight"
s2 = "23four5six7"
s3 = "2three45sixseven"
s4 = "123"
print(solution(s4))