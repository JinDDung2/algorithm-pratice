# [S3] 오리

import sys
input = sys.stdin.readline
S = input().rstrip()
visited = [False] * len(S)
cnt = 0
quack = "quack"
# 문자열 길이가 5로 나누어떨어지지 않으면 어차피 -1
# 방문처리용 만들기
# 문자열에서 q를 만나면 k만날때까지 탐색 -> 방문처리 -> quack 만들어지면 flag=False(같은오리는 개수 세지 않음)

def findDuck(start):
    global cnt
    j = 0 # q u a c k 비교 위해
    flag = True # 같은 오리인지 파악하기 위해
    for i in range(start, len(S)):
        if quack[j] == S[i] and not visited[i]:
            visited[i] = True
            if S[i] == "k":
                j = 0
                if flag:
                    flag = False
                    cnt += 1
            else:
                j += 1

if len(S) % 5 != 0:
    print(-1)
else:
    for i in range(len(S)):
        if S[i] == "q" and not visited[i]:
            findDuck(i)
    if cnt == 0 or not all(visited):
        print(-1)
    else:
        print(cnt)