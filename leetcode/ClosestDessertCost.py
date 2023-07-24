# Closest Dessert Cost 
# backtracking
result = 0
def closestCost(baseCosts: list[int], toppingCosts: list[int], target: int) -> int:
    global result
    for base in baseCosts:
        dfs(toppingCosts, target, base)
        
    return result
    
def dfs(toppingCosts: list[int], target: int, total: int):
    global result
    # 근삿값 같으면 작은수로
    if abs(result - target) == abs(total - target):
            result = min(result, total)
    # 근삿값 비교
    if abs(result - target) > abs(total - target):
        result = total
    if total > target: return

    for i in range(len(toppingCosts)):
        dfs(toppingCosts[i+1:], target, total + 0*toppingCosts[i])
        dfs(toppingCosts[i+1:], target, total + 1*toppingCosts[i])
        dfs(toppingCosts[i+1:], target, total + 2*toppingCosts[i])

print(closestCost([1, 7], [3, 4], 10)) # 10
print(closestCost([2, 3], [4, 5, 100], 18)) # 17
print(closestCost([3, 10], [2, 5], 9)) # 8
print(closestCost([1], [8, 10], 10)) # 9