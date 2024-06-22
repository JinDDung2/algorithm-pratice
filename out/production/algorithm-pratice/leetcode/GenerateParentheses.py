# Generate Parentheses

class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        result = []
        temp = ''

        self.execute(result, 0, temp, 0, n)
        return result
    
    # oc: 열린 괄호, balance: 올바른 괄호 갯수
    def execute(self, result: list, balance: int, temp: str, oc: int, n: int):
        if len(temp) == n * 2:
            result.append(temp)
            return
        
        if oc < n:
            self.execute(result, balance+1, temp+'(', oc+1, n)
        
        if balance > 0:
            self.execute(result, balance-1, temp+')', oc, n)