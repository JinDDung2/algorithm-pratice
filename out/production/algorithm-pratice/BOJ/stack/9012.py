# S4 괄호
import sys
input = sys.stdin.readline
N = int(input())

def check(s):
    lst = list(s)
    stack = []
    while lst:
        a = lst.pop()
        if a == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(a)
        elif a == '(':
            if stack and stack[-1] == ')':
                stack.pop()
            else:
                return False

    if stack:
        return False
    else:
        return True    


for _ in range(N):
    if check(input()):
        print("YES")
    else:
        print("NO")

