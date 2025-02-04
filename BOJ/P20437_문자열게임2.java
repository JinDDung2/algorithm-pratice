package BOJ;

import java.io.*;
import java.util.*;

public class P20437_문자열게임2 {

    static class Problem {
        String solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine()); // <= 100
            StringBuilder sb = new StringBuilder();
            while (T-- > 0) {
                String W = br.readLine();
                int K = Integer.parseInt(br.readLine());

                Map<Character, List<Integer>> map = new HashMap<>();
                for (char c = 'a'; c <= 'z'; c++) {
                    map.put(c, new ArrayList<>());
                }

                for (int i = 0; i < W.length(); i++) {
                    char c = W.charAt(i);
                    map.get(c).add(i);
                }

                int minLength = Integer.MAX_VALUE;
                int maxLength = Integer.MIN_VALUE;

                for(List<Integer> values : map.values()) {
                    if (values.size() < K) continue;
                    for (int i = 0; i <= values.size() - K; i++) {
                        minLength = Math.min(minLength, values.get(K - 1 + i) - values.get(i) + 1);
                        maxLength = Math.max(maxLength, values.get(K - 1 + i) - values.get(i) + 1);
                    }
                }

                if (minLength < K || maxLength < K) {
                    sb.append(-1);
                } else {
                    sb.append(minLength).append(" ").append(maxLength);
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }
    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
