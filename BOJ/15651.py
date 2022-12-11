# n과 m(3)

n, m = map(int, input().split())
lst = []


def permutations(idx):
    if idx-1 == m:
        print(" ".join(map(str, lst)))
        return

    for i in range(1, n+1):
        lst.append(i)
        permutations(idx+1)
        lst.pop()

print(permutations(1))