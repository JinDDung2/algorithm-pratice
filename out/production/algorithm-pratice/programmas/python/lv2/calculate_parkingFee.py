# 2022 KAKAO BLIND RECRUITMENT 주차 요금 계산
import math

def solution(fees, records):
    answer = []
    
    parking = dict() # IN
    time = dict() # time
    
    for record in records:
        t, c, p = record.split()
        h, m = t.split(":")
        minutes = int(h) * 60 + int(m)
        
        if p == "IN":
            parking[c] = minutes
        elif p == "OUT":
            if time.get(c) == None:
                time[c] = (minutes - parking[c])
            else:
                time[c] += (minutes - parking[c])
            del parking[c]
        # print(f"parking={parking}")
        # print(f"time={time}")
    
    # 출차 기록이 없는 차
    max_time = 24*60-1
    for k,v in parking.items():
        if time.get(k) == None:
            time[k] = (max_time - v)
        else:
            time[k] += (max_time - v)
    
    # 차량 번호 순으로 정렬
    sorted_car = sorted(time.items())
    # print(sorted_car)
    
    for k, v in sorted_car:
        fee = get_fee(v, fees)
        answer.append(fee)
    return answer

# fees = [기본 시간, 기본 요금, 단위 시간, 단위 요금]
def get_fee(minutes, fees):
    return fees[1] + math.ceil(max(0, (minutes - fees[0])) / fees[2]) * fees[3]

fees = [180, 5000, 10, 600] # [14600, 34400, 5000]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
print(solution(fees, records))