# [PCCP 모의고사 #1] 외톨이 알파벳

'''
input_string	result
"edeaaabbccd"	"de"
"eeddee"	"e"
"string"	"N"
"zbzbz"	"bz"
'''

def solution(input_string):
    dict = {}
    
    for idx, char in enumerate(input_string):
        if char not in dict:
            dict[char] = [idx]
        else:
            dict[char].append(idx)
    # print(dict)
    
    answer_list = []
    for char, value in dict.items():
        # print(char, value)
        if len(value) >= 2:
            for i in range(len(value)-1):
                if value[i+1] - value[i] > 1:
                    answer_list.append(char)
                    break
    
    answer_list.sort()
    if answer_list:
        answer = ''.join(answer_list)
    else:
        answer = 'N'
    return answer


