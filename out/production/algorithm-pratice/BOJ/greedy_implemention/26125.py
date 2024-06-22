# [S3] 눈 치우기

import sys
import math
input = sys.stdin.readline
N = int(input())
data = list(map(int, input().split()))

def solution():
    result = 0
    max_data = max(data)
    sum_data = sum(data)
    if max_data >= (sum_data - max_data):
        result = max_data
    else:
        result = math.ceil(sum_data / 2)
    
    if result > 1440:
        return -1
    return result


def fail_solution():
    data.sort()
    result = 0
    while data:
        if len(data) >= 2:
            num = min(data[-1], data[-2])
            result += num
            data[-1] -= num
            data[-2] -= num

            if data[-1] == 0 and data[-2] == 0:
                data.pop()
                data.pop()
            elif data[-1] == 0:
                data.pop()
            elif data[-2] == 0:
                data.pop(-2)
        else:
            result += data.pop()
    
    if result > 1440:
        result = -1
    
    return result

print(solution())
