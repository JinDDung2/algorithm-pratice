package programmas.java.lv2;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.toLowerCase().split("");
        boolean flag = true;
        // System.out.println(Arrays.toString(strs));

        for (String temp : strs) {
            answer += flag ? temp.toUpperCase() : temp;
            flag = temp.equals(" ") ? true : false;
        }

        return answer;
    }
}
