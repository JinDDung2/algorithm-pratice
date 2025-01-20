package BOJ;

import java.io.*;

public class P1522_문자열교환 {
    static class Problem {
        int solution() throws IOException {
            // 원형 -> 문자열 + 문자열로 합치기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String data = br.readLine();
            String doubleData = data + data;

            // 1. a의 개수를 센다.
            int countA = countCharacter(data, 'a');
            int minChanges = Integer.MAX_VALUE;
            // 2. [i:i+n]을 계속 탐색하며 b개수 찾기
            for (int i = 0; i < data.length(); i++) {
                String substring = doubleData.substring(i, i + countA);
                int countB = countCharacter(substring, 'b');
                // 3. 최솟값 할당
                minChanges = Math.min(minChanges, countB);
            }

            return minChanges;
        }

        int countCharacter(String data, char target) {
            int n = 0;
            for (char c : data.toCharArray()) {
                if (c == target) n++;
            }

            return n;
        }
    }


    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
