# 체스판
n, m = map(int, input().split())
data = [input() for _ in range(n)]
result = []

# 첫시작이 b 일때와 w 일때 나누기
# 홀수끼리 같아야하고 짝수끼리 같아야함
# WBWBWBWB
# BWBWBWBW
# WBWBWBWB
# BWBBBWBW
# WBWBWBWB
# BWBWBWBW
# WBWBWBWB
# BWBWBWBW

for i in range(n-7):
    for j in range(m-7):
        even_W = 0
        odd_W = 0
        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a+b) % 2 == 0:
                    if data[a][b] != 'B': # B
                        odd_W += 1
                    if data[a][b] != 'W':
                        even_W += 1
                else:
                    if data[a][b] != 'B':
                        even_W += 1
                    if data[a][b] != 'W':
                        odd_W += 1
        
        result.append(even_W)
        result.append(odd_W)
print(min(result))

# print(min(result))