# 2018 KAKAO BLIND RECRUITMENT [1차] 뉴스 클러스터링

from collections import Counter

def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    
    # print("1",str1)
    # print("2",str2)
    
    str1_lst = []
    str2_lst = []
    
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            str1_lst.append(str1[i] + str1[i+1])
    
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            str2_lst.append(str2[i] + str2[i+1])
    
    # print(str1_lst)
    # print(str2_lst)
    
    intersection = sum((Counter(str1_lst) & Counter(str2_lst)).values())
    union = sum((Counter(str1_lst) | Counter(str2_lst)).values())
    
    # print(intersection)
    # print(union)

    answer = 1 if not union else intersection / union
    return int(answer * 65536)

def sol(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    
    # print("1",str1)
    # print("2",str2)
    
    str1_lst = []
    str2_lst = []
    
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            str1_lst.append(str1[i] + str1[i+1])
    
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            str2_lst.append(str2[i] + str2[i+1])
    
    # print(str1_lst)
    # print(str2_lst)

    intersection = set(str1_lst) & set(str2_lst)
    union = set(str1_lst) | set(str2_lst)

    if len(union) == 0 :
        return 65536

    gyo_sum = sum([min(str1.count(word), str2.count(word)) for word in intersection])
    hap_sum = sum([max(str1.count(word), str2.count(word)) for word in union])

    return int((gyo_sum/hap_sum)*65536)
