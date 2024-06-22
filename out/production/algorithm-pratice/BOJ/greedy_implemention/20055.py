# 컨베이어 벨트 위에 로봇
from collections import deque

n, k = map(int, input().split())    # n=길이 / k=내구도 0인 칸
conveyer = deque(list(map(int, input().split()))) # 선입선출

# 로봇은 올리는 위치에만 올릴 수 있다. 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다
robot = deque([0] * n)
cnt = 0    # 1.로봇이동 2.컨베이어위에 올리는 것

# conveyer.rotate(1)
# robot.rotate(1)
# print("c: ", conveyer, "r: ", robot)

while True:
    # 회전
    conveyer.rotate(1)
    robot.rotate(1)
    robot[-1] = 0
    # print("c: ", conveyer, "r: ", robot)

    if sum(robot):
        # 전전단계에서 확인할 내구도
        for i in range(n-2, -1, -1):
            # 이동하면 감소
            if robot[i] == 1 and robot[i+1] == 0 and conveyer[i+1] >= 1:
                robot[i+1] = 1
                robot[i] = 0
                conveyer[i+1] -= 1
            robot[-1] = 0
    # print("c: ", conveyer, "r: ", robot)

    #컨베이어에 올리면 내구도 감소
    if robot[0] == 0 and conveyer[0] >= 1:
        robot[0] = 1
        conveyer[0] -= 1
    # print("c: ", conveyer, "r: ", robot)
            
    cnt += 1

    # 탈출
    if conveyer.count(0) >= k:
        break

print(cnt)

