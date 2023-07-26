# Remove K Digits
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:

        # 값을 하나씩 스택에 넣기
        # stack[-1] > 들어오는 값 -> stack.pop(), k-= 1
        stack = []
        for n in num:
            while stack and k > 0 and stack[-1] > n:
                stack.pop()
                k -= 1
            if stack or n != "0":
                stack.append(n)

        print(f"stack={stack}, k={k}")
        if k:
            stack = stack[:-k]
        return ''.join(stack) if stack else "0"