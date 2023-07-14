#[lv3] 가장 긴 팰린드롬

def ispalindrome(s):
    if s == s[::-1]:
        return True

def solution(s):
    answer = 0
    for i in range(len(s)):
        for j in range(i+1, len(s)+1):
            if ispalindrome(s[i:j]):
                # print(i, j, s[i:j])
                answer = max(answer, j-i)


    return answer

# ------------------------------------------
# 실패 -> abca 일 경우 안됨
def first(s):
    answer = 0

    # 앞 뒤가 같으면 left+=1, right -=1 answer += 2
    # 다르면 right -= 1
    left = 0
    right = len(s)-1
    while True:
        # abcde -> abcd -> abc -> ab -> a
        # 탈출조건 left == right answer += 1
        if left == right:
            answer += 1
            break
        
        if s[left] == s[right]:
            left += 1
            right -= 1
            answer += 2
        else:
            right -= 1

    return answer

