package BOJ;

import java.io.*;

public class P17615_볼모으기 {

    static class Problem {

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            String data = br.readLine();

            // 공 전체에서 R, B의 개수
            int totalRed = 0;
            int totalBlue = 0;
            for (char c : data.toCharArray()) {
                if (c == 'R') totalRed++;
                else totalBlue++;
            }

            // 왼쪽에서 연속된 R, B의 개수
            int prefixRed = 0;
            int prefixBlue = 0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == 'R') prefixRed++;
                else break;
            }
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == 'B') prefixBlue++;
                else break;
            }

            // 오른쪽에서 연속된 R, B의 개수
            int suffixRed = 0;
            int suffixBlue = 0;
            for (int i = data.length() - 1; i >= 0; i--) {
                if (data.charAt(i) == 'R') suffixRed++;
                else break;
            }
            for (int i = data.length() - 1; i >= 0; i--) {
                if (data.charAt(i) == 'B') suffixBlue++;
                else break;
            }

            // 네 가지 경우의 비용(이동해야 하는 공의 수)
            // 1. 모든 R을 왼쪽으로 몰기
            int costRLeft = totalRed - prefixRed;
            // 2. 모든 R을 오른쪽으로 몰기
            int costRRight = totalRed - suffixRed;
            // 3. 모든 B를 왼쪽으로 몰기
            int costBLeft = totalBlue - prefixBlue;
            // 4. 모든 B를 오른쪽으로 몰기
            int costBRight = totalBlue - suffixBlue;

            // 네 가지 이동 횟수 중 최솟값
            return Math.min(
                    Math.min(costRLeft, costRRight),
                    Math.min(costBLeft, costBRight)
            );
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }

}
