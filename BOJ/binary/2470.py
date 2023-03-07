# 두 용액
# 산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.
import sys
input = sys.stdin.readline
n = int(input())
lst = list(map(int ,input().split()))
lst.sort()

# 포인터를 왼쪽 끝과 오른쪽 끝 설정
start = 0
end = n-1

# 첫 값은 맨왼쪽 끝과 오른쪽끝의 합
temp = abs(lst[start] + lst[end])
rst = [lst[start], lst[end]]
# 왼쪽 인덱스가 오른쪽 인덱스 값을 넘어갈 경우 stop
# print(lst)
while start < end:
    left = lst[start]
    right = lst[end]

    # 두 값의 합
    s = left + right
    # print(f"left={left}, right={right}, s={s}, temp={temp}")
    # 이전에 저장해두던 값보다 두 수의 절댓값의 차가 낮으면 temp 초기화
    if abs(s) < temp:
        temp = abs(s)
        rst = [left, right]
        if temp == 0:
            break
    
    # 값이 음수면 -값을 줄인다 or +값을 늘린다?.
    if s < 0:
        start += 1
    # 값이 양수면 +값을 줄인다 or -값을 줄인다?.
    else:
        end -= 1

print(*rst)
