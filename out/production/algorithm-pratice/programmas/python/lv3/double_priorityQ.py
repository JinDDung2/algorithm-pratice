# 힙(Heap) 이중우선순위큐
import heapq

def solution(operations):
    heap = []
    
    for o in operations:
        fir, sec = o.split()
        if fir == 'I':
            heapq.heappush(heap, int(sec))
        else:
            if len(heap) == 0:
                pass
            elif sec == '-1':
                heapq.heappop(heap)
            elif sec == '1':
                heap = heapq.nlargest(len(heap), heap)[1:]
                heapq.heapify(heap)
        # print(f"o={o}, heap={heap}")
    if heap:
        return [heapq.nlargest(len(heap), heap)[0], heap[0]]
    else:
        return [0,0]