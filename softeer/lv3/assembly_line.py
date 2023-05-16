# 조립 라인
import sys
input = sys.stdin.readline

N = int(input())
# A 작업시간, B 작업시간, A->B이동시간, B->A 이동시간
A, B, AtoB, BtoA = [0]*(N+1), [0]*(N+1), [0]*(N+1), [0]*(N+1)
for i in range(1, N):
    Ai, Bi, AtoB[i], BtoA[i] = map(int, input().split())

    if i == 1:
        A[i], B[i] = Ai, Bi
        continue

    # A 업데이트
    startA = A[i-1] + Ai
    startB = B[i-1] + BtoA[i-1] + Ai
    A[i] = min(startA, startB)
    # B 업데이트
    startA = A[i-1] + AtoB[i-1] + Bi
    startB = B[i-1] + Bi
    B[i] = min(startA, startB)

AN, BN = map(int, input().split())
# A 업데이트
startA = A[N-1] + AN
startB = B[N-1] + BtoA[N-1] + AN
A[N] = min(startA, startB)
# B 업데이트
startA = A[N-1] + AtoB[N-1] + BN
startB = B[N-1] + BN
B[N] = min(startA, startB)

print(min(A[N], B[N]))