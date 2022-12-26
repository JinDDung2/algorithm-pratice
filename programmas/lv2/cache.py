# 2018 KAKAO BLIND RECRUITMENT [1차] 캐시
from collections import deque

def solution(cacheSize, cities):
    time = 0
    
    que = deque([])
    for city in cities:
        city = city.lower()
        
        if city in que:
            que.remove(city)
            que.append(city)
            time += 1
        else:
            time += 5
            
            if cacheSize == 0:
                continue
                
            if len(que) >= cacheSize:
                que.popleft()
            que.append(city)
    return time