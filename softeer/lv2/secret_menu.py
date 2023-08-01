# [21년 재직자 대회 예선] 비밀 메뉴

import sys
input = sys.stdin.readline

# test
M, N, K = map(int, input().split())
menu = ''.join(input().rstrip())
button = ''.join(input().rstrip())

if menu in button:
    print("secret")
else:
    print("normal")

# test 1
'''
M, N, K = map(int, input().split())
menu = list(map(str, input().split()))
button = list(map(str, input().split()))

m = ''.join(menu)
b = ''.join(button)

if m in b:
    print("secret")
else:
    print("normal")
'''