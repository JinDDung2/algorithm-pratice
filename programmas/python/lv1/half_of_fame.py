import heapq

def solution(k, score):
    answer = [0] * len(score)
    heap = []
    for i in range(len(score)):
        if i < k:
            heapq.heappush(heap, score[i])
        else:
            if score[i] > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, score[i])
        
        # print(f"i={i}, heap={heap}")
        answer[i] = heap[0]
        # print(f"ans={answer}")

    return answer


print(solution(3, [10, 100, 20, 150, 1, 100, 200]))