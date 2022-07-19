# 시저암호
# 공백 32
# A~Z 65~90 // 26개
# a~z 97~122

# def solution(s, n):
#     answer = ''
#     for i in s:
#         if ord(i) == 32:
#             answer += ' '
#         else:
#             char = ord(i)+n
#             if i.isupper() == True:
#                 if char > 90:
#                     answer += chr(char-26)
#                 else:
#                     answer += chr(char)
#             else:
#                 if char > 122:
#                     answer += chr(char-26)
#                 else:
#                     answer += chr(char)
        
#     return answer

def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i]= chr((ord(s[i])-ord('A')+ n)%26 + ord('A'))
        elif s[i].islower():
            s[i]= chr((ord(s[i])-ord('a')+ n)%26 + ord('a'))
    
    answer = "".join(s)
    return answer


print(solution("AB", 1))
print(solution("z", 1))
print(solution("a B z", 4))