# 최대 공약수 (Grate common divide)
def gcd(a, b):
    if a % b == 0:
        return b
    return gcd(b, a%b)
    
print(gcd(192, 162))