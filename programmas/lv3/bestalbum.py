# 코딩테스트 고득점 Kit [해쉬] 베스트 앨범
def solution(genres, plays):
    answer = []
    total_dict = {} # 장르마다 플레이 수
    per_dict = {} # 장르 안의 각 노래마다 플레이 수

    for i in range(len(genres)):
        total_dict[genres[i]] = total_dict.get(genres[i], 0) + plays[i]
        per_dict[genres[i]] = per_dict.get(genres[i], []) + [(plays[i], i)]
    
    # print(f"total_dict:{total_dict}")
    # print(f"per_dict:{per_dict}")

    # 총 재생횟수 내림차순 정렬
    total_sort = sorted(total_dict.items(), key= lambda x:x[1], reverse=True)
    # print(total_sort)

    # 장르마다 노래플레이 수 내림차순 정렬
    for genre in per_dict:
        # print(per_dict[genre])
        per_dict[genre] = sorted(per_dict[genre], key= lambda x: (-x[0]))

    # answes 배열에 장르별 노래재생횟수 넣기
    for (genre, totalPlay) in total_sort:
        print(per_dict[genre])
        for (plays, idx) in per_dict[genre][:2]:
            answer.append(idx)
            
    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

def try2(genres, plays):
    answer = []
    # 장르별 총 플레이 수 저장
    genre_dict = {}
    # 장르 기준으로 플레이 수와 인덱스 저장
    play_dict = {}
    
    for i in range(len(genres)):
        genre_dict[genres[i]] = genre_dict.get(genres[i], 0) + plays[i]
        play_dict[genres[i]] = play_dict.get(genres[i], []) + [(plays[i], i)]
    
    # 장르 총 플레이수 내림차순
    genre_dict = sorted(genre_dict.items(), key= lambda x:(-x[1]))
    
    # 장르별 플레이 수 내림차순
    for k in play_dict:
        play_dict[k].sort(key= lambda x:(-x[0]))
    
    # print("g", genre_dict)
    # print("p", play_dict)
    
    # 총 장르 * 2
    for k, v in genre_dict:
        for p, i in play_dict[k][:2]:
            answer.append(i)
    
    return answer

print(solution(genres, plays))