# [S3] 단어 뒤집기 2

import sys
input = sys.stdin.readline

data = input().rstrip()
stack = []
flag = False
result = ''

for s in data:
    # 공백
    if s == ' ':
        while stack:
            result += stack.pop()
        result += ' '
    # 태그 시작
    elif s == '<':
        while stack:
            result += stack.pop()
        flag = True
        result += s
    
    # 태그 끝
    elif s == '>':
        flag = False
        result += s

    # 태그 사이
    elif flag:
        result += s
    
    # 숫자나 알파벳
    else:
        stack.append(s)

# 마지막 한 단어 추가
while stack:
    result += stack.pop()

print(result)