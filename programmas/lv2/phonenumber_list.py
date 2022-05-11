# 전화번호 목록

def solution(phone_book):
    # answer = True
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) < len(phone_book[i+1]):
            if phone_book[i] in phone_book[i+1]:
                return False
    return True

phone_book = ["12","124","1235","567","88"]
print(solution(phone_book))