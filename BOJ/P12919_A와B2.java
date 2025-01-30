package BOJ;

import java.io.*;
import java.util.*;

public class P12919_A와B2 {

    static class Problem {

        boolean possible = false;
        Set<String> visited = new HashSet<>();
        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String S = br.readLine(); // 1 <= S < 50
            String T = br.readLine(); // S < T <= 50

            // T -> S로 가는 방식
            dfs(T, S);
            return possible ? 1 : 0;
        }

        void dfs(String curr, String S) {
            // 비교 값이 같다면 1 출력
            if (Objects.equals(curr, S)) {
                possible = true;
                return;
            }

            // T <= S 거나 이미 탐색했다면 0 출력
            if (curr.length() <= S.length() || visited.contains(curr)) {
                return;
            }

            visited.add(curr);

            // 마지막 문자가 A라면 제거 가능
            if (curr.charAt(curr.length() - 1) == 'A') {
                dfs(curr.substring(0, curr.length() - 1), S);
            }

            // 맨 앞의 문자가 B라면 제거하고 뒤집기 가능
            if (curr.charAt(0) == 'B') {
                dfs(new StringBuilder(curr.substring(1)).reverse().toString(), S);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
