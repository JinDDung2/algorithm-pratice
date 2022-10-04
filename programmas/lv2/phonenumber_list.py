# 전화번호 목록
p1 = ["119", "97674223", "1195524421"]
p2 = ["123","456","789"]

def solution(phone_book):
    # answer = True
    phone_book.sort()
    if len(phone_book) == 1:
        return True
    
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) < len(phone_book[i+1]):
            if phone_book[i] == phone_book[i+1][0:len(phone_book[i])]:
                return False
    
    
    return True

def solution2(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            # print(temp)
            if temp in hash_map and temp != phone_number:
                answer = False
    # print(hash_map)
    return answer

a = solution2(p1)
print(a)