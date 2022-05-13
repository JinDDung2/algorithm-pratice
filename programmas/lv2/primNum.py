numbers = "1234"
prime = []

# 만들어지는 숫자들을 리스트로 만든다

for i in range(len(numbers)):
    num = numbers[i]
    prime.append(int(num))
    for j in range(i+1, len(numbers)):
        num += numbers[j]
        prime.append(int(num))
print(prime)