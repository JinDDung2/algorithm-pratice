# 코딩테스트 고득점 Kit [스택/큐] 다리를 지나는 트럭
from collections import deque

# 테스트 케이스5 시간초과 / 시간이 오래걸림
def solution(bridge_length, weight, truck_weights):
    answer = 0
    waiting_truck = deque(truck_weights)
    going_truck = deque([0]*bridge_length)

    while len(going_truck):
        answer += 1
        going_truck.popleft()
        if waiting_truck:
            if sum(going_truck)+waiting_truck[0] <= weight:
                truck = waiting_truck.popleft()
                going_truck.append(truck)
            else:
                going_truck.append(0)
        print(f"answer={answer}, going={going_truck}, waiting={waiting_truck}")
    return answer


# sum을 연산을 통해 시간효율성 증대
def solution2(bridge_length, weight, truck_weights):
    answer = 0
    waiting_truck = deque(truck_weights)
    going_truck = deque([0]*bridge_length)
    sum = 0

    while len(going_truck):
        answer += 1
        sum -= going_truck.popleft()
        # print(f"sum={sum}")
        if waiting_truck:
            if sum+waiting_truck[0] <= weight:
                truck = waiting_truck.popleft()
                going_truck.append(truck)
                sum += truck
            else:
                going_truck.append(0)
        # print(f"answer={answer}, going={going_truck}, waiting={waiting_truck}")
    return answer

def try2(bridge_length, weight, truck_weights):
    
    truck_weights = deque(truck_weights)
    truck = deque([0] * bridge_length) # 다리 위 개수
    trucks = 0 # 다리 위 무게
    time = 0
    
    while truck:
        time += 1
        trucks -= truck.popleft()
        
        if truck_weights:
            if trucks + truck_weights[0] <= weight:
                num = truck_weights.popleft()
                truck.append(num)
                trucks += num
            else:
                truck.append(0)
                
    return time


print(solution(2, 10, [7,4,5,6]))