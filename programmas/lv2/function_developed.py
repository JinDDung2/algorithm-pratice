# 기능 개발

def solution(progresses, speeds):
    answer = []
    day = 1
    cnt = 0
    
    while progresses:
        if (progresses[0] + day*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            cnt += 1
            # print(day)
        else:
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
            day += 1
            
    answer.append(cnt)
    return answer

progresses=[93, 30, 55]
speeds=	[1, 30, 5]
print(solution(progresses, speeds))