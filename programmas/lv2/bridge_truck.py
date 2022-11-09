# 다리를 지나는 트럭
from collections import deque

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



print(solution(2, 10, [7,4,5,6]))