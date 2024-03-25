package BOJ.implementation;

import java.util.*;

//[S3] 1213. 팰린드롬 만들기

public class 팰린드롬만들기_1213 {
    // 출현 빈도가 홀수인 문자는 펠린드롬의 중앙에 위치해야 합니다.
    // 출현 빈도가 짝수인 문자는 펠린드롬의 양쪽에 대칭되게 배치
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine().trim();
        // 출력할 때 사전순으로 하기 위해 TreeMap 사용
        Map<Character, Integer> map = new TreeMap<>();

        // 각 문자의 출현 빈도를 저장
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        char middle = 0; // 가운데 올 문자 저장
        // 가운데 문자를 중복되지 않게 하기 위해, 홀수 개수인 문자 중 하나만 선택.
        // 만약 홀수 개수인 문자가 두 개 이상이라면, "I'm Sorry Hansoo"를 출력하고 종료.
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                if (middle == 0) {
                    middle = key;
                    map.put(key, map.get(key) - 1);
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        // 가운데 문자가 선택되면, 해당 문자를 가운데로 두고 나머지 문자들을 양쪽에 대칭되게 배치하여 펠린드롬을 완성
        // 1. 가운데 문자를 기준으로 왼쪽을(half) 완성시킨다.
        StringBuilder half = new StringBuilder();

        for (Character key : map.keySet()) {
            int cnt = map.get(key) / 2;
            // repeat method -> java 11 에 추가.
            String repeated = String.valueOf(key).repeat(cnt);
            half.append(repeated);// 왼쪽에 추가
        }

        result.append(half);
        // 2. 왼쪽(half)을 완성시킨 후 가운데 올 문자를 추가한다.
        if (middle != 0) {
            result.append(middle);
        }
        // 3. 가운데 문자 기준 대칭이다 -> 오른쪽 = 왼쪽.reverse
        result.append(half.reverse());
        System.out.println(result);
    }
}
