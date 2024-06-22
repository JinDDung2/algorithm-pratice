# 연습문제 줄 서는 방법
def factorial(n):
    if n < 1:
        return 1
    else:
        return n * factorial(n-1)

def solution(n, k):
    # 한 숫자당 (n-1)! 경우의 수 존재
    answer = []
    num_lst = [i for i in range(1, n+1)]
    # idx => 5 // 2 = 2가 된다. k = k % 2를 하면 5 % 2 = 1이 된다. 즉 2번 지나가고 1이 남은 것이다. 그럼 3번째 것의 1번째가 답이 된다는 것을 알 수 있다. 그러므로 3을 넣어주기 위해 index가 2이므로 numberList.pop(index)를 하면 3이 들어가게된다.
    while (n != 0):
        temp = factorial(n-1)
        idx = k // temp
        k %= temp
        if k == 0:
            answer.append(num_lst.pop(idx-1))
        else:
            answer.append(num_lst.pop(idx))
        # print(f"n={n}, idx={idx}, k={k}, temp={temp}, answer={answer}, num_list={num_lst}")
        n -= 1
    return answer

from itertools import permutations

# 효율성 x
def incorr_solution(n, k):
    lst = [i for i in range(1, n+1)]
    a = list(permutations(lst, n))
    answer = list(a[k-1])
    return answer