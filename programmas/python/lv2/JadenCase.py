# JadenCase 문자열 만들기

# 정확성: 44.4 -> 런타임에러
# def solution(s):
#     answer = ''
#     s.lower()

#     s_list = s.lower().split(" ")
#     for i in s_list:
#         # print(i[0])
#         if not i[0].isdigit():
#             # print(i[0].upper())
#             answer += (i[0].upper())
#         else:
#             answer += i[0]
#         answer += (i[1:])

#         if i != s_list[-1]:
#             answer += " "
#         # print(answer)


#     return answer


# a = "3people unFollowed me"
# print(a.title())

# 정확성: 44.4 
def solution(s):
    s_list = s.split(" ")
    for i in range(len(s_list)):
        s_list[i] = s_list[i].capitalize()
    answer = " ".join(s_list)
    return answer

print(solution("3people unFollowed me"))