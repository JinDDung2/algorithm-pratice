from operator import ge
from re import T
import re


def solution(genres, plays):
    answer = []
    total_dict = {} # 장르마다 플레이 수
    per_dict = {} # 장르 안의 각 노래마다 플레이 수

    
    for i in range(len(genres)):
        total_dict[genres[i]] = total_dict.get(genres[i], 0) + plays[i]
        per_dict[genres[i]] = per_dict.get(genres[i], []) + [(plays[i], i)]
    
    # print(f"total_dict:{total_dict}")
    # print(f"per_dict:{per_dict}")

    # 내림차순 정렬
    total_sort = sorted(total_dict.items(), key= lambda x:x[1], reverse=True)
    per_sort = sorted(per_dict.items(), key= lambda x: (-x[0], x[1]), reverse=True)
    # print(total_sort)

    # 장르마다 2개 선택
    first_genre = total_sort[0][0]
    second_genre = total_sort[1][0]
    # print(per_dict.items())
    print(per_sort)
    
    return answer

genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

print(solution(genres, plays))