# 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도

def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        binarynum = bin(arr1[i] | arr2[i])
        s = binarynum[2:].zfill(n)
        s = s.replace("1", "#").replace("0", " ")
        # print("s", s)
        answer.append(s)
        
    return answer


print("1", solution(5, [9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))
print("2", solution(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]))