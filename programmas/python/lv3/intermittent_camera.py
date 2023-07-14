# 단속카메라

def solution(routes):
    # 진출 시점, 도착 시첨 모두가 필요한 경우라면 진출 시점에 카메라가 있어야 합리적
    # 진출 시점으로 정렬
    routes.sort(key= lambda x:x[0])
    # 처음 있는 라우터는 도착시점에 설치, 나머지는 진입시점에 설치
    # 설치한 곳이랑 진입시점이랑 비교하여, 진입시점 > 설치한 곳 일 경우에 또 설치
    cnt = 0
    camera = -30001
    
    for start, end in routes:
        if start > camera:
            # print(start, end, camera)
            cnt += 1
            camera = end
        camera = min(camera, end)
    
    return cnt