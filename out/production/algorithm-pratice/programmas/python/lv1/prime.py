def Prime(n):
    answer = [True] * (n+1)
    answer[0], answer[1] = False, False

    for i in range(2, int(n**0.5)+1):
        if answer[i]:
            j = 2

            while (i*j) <= n:
                answer[i*j] = False
                j += 1
    
    rst = 0
    for i in answer:
        if i:
            rst += 1

    return rst


print(Prime(10))
print(Prime(5))