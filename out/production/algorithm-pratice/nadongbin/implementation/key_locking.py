# 자물쇠와 열쇠

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

def rotate90(arr):
    n = len(arr)
    m = len(arr[0])
    result = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            result[j][n-i-1] = arr[i][j]
    
    return result


def check(new_lock):
    lock_lenght = len(new_lock) // 3
    for i in range(lock_lenght, lock_lenght * 2):
        for j in range(lock_lenght, lock_lenght * 2):
            if new_lock[i][j] != 1:
                return False
    return True


def solution(key, lock):
    n = len(lock)
    m = len(key)
    # 3배 만들기
    new_lock = [[0] * (n*3) for _ in range(n*3)]
    # 기존 자물쇠 넣기
    for i in range(n):
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]

    # 4가지 방향 확인
    for _ in range(4):
        # 열쇠 회전
        key = rotate90(key)
        for x in range(2*n):
            for y in range(2*n):
                # 열쇠 끼어넣기
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+i] += key[i][j]
                
                # 자물쇠랑 키 합이 1이어야 true
                if check(new_lock):
                    return True
                
                # 열쇠 다시빼기
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+i] -= key[i][j]
    
    return False


print(solution(key, lock))