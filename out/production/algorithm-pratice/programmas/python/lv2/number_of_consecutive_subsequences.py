def solution(elements):
    lst = []
    size = len(elements)
    num = 1
    
    for element in elements:
        lst.append(element)
    while num <= size:
        for i in range(size):
            plus_idx = (i+num) % size
            if i < plus_idx:
                number = sum(elements[i:plus_idx])
            else:
                number = sum(elements[i:size]) + sum(elements[:plus_idx])
            # print(f"num={num}, i={i}, plus_idx={plus_idx}, number={number}")        
            lst.append(number)
        num += 1
            
    # print(len(set(lst)))
    return len(set(lst))

## 더 좋게 바꾸어보기
def solution2(elements):
    size = len(elements)
    answer = set()

    for i in range(size):
        ssum = elements[i]
        answer.add(ssum)
        for j in range(i+1, i+size):
            ssum += elements[j % size]
            answer.add(ssum)
    
    # print(answer)
    return  len(answer)

elements = [7,9,1,1,4] # answer = 18
print(solution2(elements))