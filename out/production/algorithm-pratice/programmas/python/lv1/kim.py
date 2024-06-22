# 서울에서 김서방찾기

def solution(seoul):
    for i in range(len(seoul)):
        if seoul[i] == "Kim":
            return f"김서방은 {i}에 있다"
    

print(solution(["Jane", "Kim"]))