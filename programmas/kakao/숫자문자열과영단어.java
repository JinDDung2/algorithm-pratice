package programmas.kakao;

import java.util.*;

public class 숫자문자열과영단어 {

    public int solution(String s) {
        int answer = 0;
        String result = "";
        String temp = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result += c;
                continue;
            }

            temp += c;
            if (map.containsKey(temp)) {
                result += map.get(temp);
                temp = "";
            }
        }

        return Integer.valueOf(result);
    }

}
