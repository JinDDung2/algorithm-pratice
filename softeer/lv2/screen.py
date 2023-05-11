# [21년 재직자 대회 예선] 전광판

import sys

input = sys.stdin.readline

num_dict = {"0" : [1, 1, 1, 1, 1, 1, 0],
            "1" : [0, 0, 1, 1, 0 ,0, 0],
            "2" : [0, 1, 1, 0, 1, 1, 1],
            "3" : [0, 1, 1, 1, 1, 0, 1],
            "4" : [1, 0, 1, 1, 0, 0, 1],
            "5" : [1, 1, 0, 1, 1, 0, 1],
            "6" : [1, 1, 0, 1, 1, 1, 1],
            "7" : [1, 1, 1, 1, 0, 0, 0],
            "8" : [1, 1, 1, 1, 1, 1, 1],
            "9" : [1, 1, 1, 1, 1, 0, 1],
            " " : [0, 0, 0, 0, 0, 0 ,0]
            }

T = int(input())
for i in range(T):
    A, B = input().strip().split()
    
    zero_a = 5 - len(A)
    zero_b = 5 - len(B)

    a = ' ' * zero_a + A
    b = ' ' * zero_b + B

    count = 0
    for i in range(5):
        for j in range(7):
            if num_dict[a[i]][j] != num_dict[b[i]][j]:
                count += 1
    
    print(count)

'''
T = int(input())
for i in range(T):
    A, B = input().strip().split()
    A = list(A)
    B = list(B)

    count = 0
    ''''''
    if len(A) == len(B):
        for _ in range(len(A)):
            a = A.pop()
            b = B.pop()
            for i in range(7):
                if num_dict[a][i] != num_dict[b][i]:
                    count += 1
    elif len(A) > len(B):
        for _ in range(len(B)):
            a = A.pop()
            b = B.pop()
            for i in range(7):
                if num_dict[a][i] != num_dict[b][i]:
                    count += 1
        
        for _ in range(len(A)):
            a = A.pop()
            count += sum(num_dict[a])

    else:
        for _ in range(len(A)):
            a = A.pop()
            b = B.pop()
            for i in range(7):
                if num_dict[a][i] != num_dict[b][i]:
                    count += 1
        
        for _ in range(len(B)):
            b = B.pop()
            count += sum(num_dict[b])
    
    print(count)
'''