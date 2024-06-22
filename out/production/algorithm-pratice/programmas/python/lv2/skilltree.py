# 스킬트리
def incorrect_solution(skill, skill_trees):
    answer = 0
    # 1 <= 리스트길이 <= 20
    # 2 <= 문자열 <= 26
    # 중복 스킬 x
    # 스킬트리에 있는 스킬 순서를 꺼낸다
    # 주어진 스킬과 인덱스 비교한다(순서)
    for skill_tree in skill_trees:
        temp = []
        check = True
        
        for s in skill:
            if s not in skill_tree:
                temp.append(-1)
            else:
                for i in range(len(skill_tree)):
                    if skill_tree[i] == s:
                        temp.append(i)
        
        print(f"skill_tree={skill_tree}, temp={temp}")
        for idx in range(len(temp)-1):
            if temp[idx] > temp[idx+1]:
                check = False
                break
        
        if check:
            answer += 1
                    
    return answer


def solution(skill, skill_trees):
    answer = 0
    # skill_trees에서 skill_tree 꺼내기
    # 있는 값만 더하는 변수만들기?
    # 일치하는 값들의 길이만큼 잘라서 skill과 비교
    for skill_tree in skill_trees:
        a = ""
        for s in skill_tree:
            if s in skill:
                a += s

        if skill[:len(a)] == a:
            answer += 1
    return answer
