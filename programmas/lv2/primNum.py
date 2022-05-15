numbers = "1234"
prime = []

def check(number):
    if number == 0 or number == 1:
        return False
    
    for i in range(2, number*0.5):
        if number % i == 0:
            return False

    return True

    
