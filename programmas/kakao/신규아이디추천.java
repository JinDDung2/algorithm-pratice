package programmas.kakao;

public class 신규아이디추천 {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();
        // System.out.println("1:" + answer);
        // 2단계
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        // System.out.println("2:" + answer);
        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        // System.out.println("3:" + answer);
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        // System.out.println("4:" + answer);
        // 5단계
        if (answer.isEmpty())
            answer = "a";
        // System.out.println("5:" + answer);
        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        answer = answer.replaceAll("[.]$", "");
        // System.out.println("6:" + answer);
        // 7단계
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        // System.out.println("7:" + answer);
        return answer;
    }

    /*
     * public String solution(String new_id) {
     * 
     * String s = new KAKAOID(new_id)
     * .replaceToLowerCase()
     * .filter()
     * .toSingleDot()
     * .noStartEndDot()
     * .noBlank()
     * .noGreaterThan16()
     * .noLessThan2()
     * .getResult();
     * 
     * 
     * return s;
     * }
     * 
     * private static class KAKAOID {
     * private String s;
     * 
     * KAKAOID(String s) {
     * this.s = s;
     * }
     * 
     * private KAKAOID replaceToLowerCase() {
     * s = s.toLowerCase();
     * return this;
     * }
     * 
     * private KAKAOID filter() {
     * s = s.replaceAll("[^a-z0-9._-]", "");
     * return this;
     * }
     * 
     * private KAKAOID toSingleDot() {
     * s = s.replaceAll("[.]{2,}", ".");
     * return this;
     * }
     * 
     * private KAKAOID noStartEndDot() {
     * s = s.replaceAll("^[.]|[.]$", "");
     * return this;
     * }
     * 
     * private KAKAOID noBlank() {
     * s = s.isEmpty() ? "a" : s;
     * return this;
     * }
     * 
     * private KAKAOID noGreaterThan16() {
     * if (s.length() >= 16) {
     * s = s.substring(0, 15);
     * }
     * s = s.replaceAll("[.]$", "");
     * return this;
     * }
     * 
     * private KAKAOID noLessThan2() {
     * StringBuilder sBuilder = new StringBuilder(s);
     * while (sBuilder.length() <= 2) {
     * sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
     * }
     * s = sBuilder.toString();
     * return this;
     * }
     * 
     * private String getResult() {
     * return s;
     * }
     * }
     */
}
