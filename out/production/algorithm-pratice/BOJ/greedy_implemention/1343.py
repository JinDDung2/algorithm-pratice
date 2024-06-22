# [S5] 폴리오미노

# X개수, .개수로 리스트 넣기
# for문 반복 -> "AAAA"* 4로 나눈 몫 / "BB"* 4로나눈 나머지 / 4로 나눈 나머지가 1, 3일경우 result = -1
import sys
input = sys.stdin.readline
S = input()
result = ""

data = []
X_cnt = 0
dot = 0
for s in S:
    if s == "X":
        X_cnt += 1
        if dot != 0:
            data.append("." * dot)
            dot = 0
    if s == ".":
        dot += 1
        if X_cnt != 0:
            data.append("X"*X_cnt)
            X_cnt = 0

if X_cnt != 0:
    data.append("X"*X_cnt)
if dot != 0:
    data.append("."*dot)

for i in range(len(data)):
    if data[i][0] == "X":
        A_size = int(len(data[i]) / 4) # 몫만큼 붙여
        B_size = len(data[i]) % 4 # 2이면 붙여
        data[i] = "AAAA" * A_size
        if B_size == 0:
            pass
        elif B_size == 2:
                data[i] += "BB"
        else:
            result = "-1"
            break

if result != "-1":
    for i in range (len(data)):
        result += data[i]

print(result)