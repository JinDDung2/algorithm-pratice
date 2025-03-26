package BOJ;

import java.io.*;
import java.util.*;

public class P7490_0만들기 {
    static class Problem {
        int T;
        int N;
        List<String> results;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                N = Integer.parseInt(br.readLine());
                results = new ArrayList<>();

                backtracking(1, "1");
                Collections.sort(results);

                for (String s : results) {
                    bw.write(s + "\n");
                }

                bw.write("\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        void backtracking(int num, String temp) {
            if (num == N) {
                if (evaluate(temp.replaceAll(" ", "")) == 0) results.add(temp);
                return;
            }

            int next = num + 1;

            backtracking(next, temp + "+" + next);
            backtracking(next, temp + "-" + next);
            backtracking(next, temp + " " + next);
        }

        int evaluate(String str) {
            List<Integer> nums = new ArrayList<>();
            List<Character> ops = new ArrayList<>();

            int idx = 0;
            while (idx < str.length()) {
                int j = idx;

                while(j < str.length() && Character.isDigit(str.charAt(j))) {
                    j++;
                }

                nums.add(Integer.parseInt(str.substring(idx, j)));

                if (j < str.length()) {
                    ops.add(str.charAt(j));
                }

                idx = j + 1;
            }

            int result = nums.get(0);
            for (int i = 0; i < ops.size(); i++) {
                char op = ops.get(i);
                if (op == '+') result += nums.get(i + 1);
                else result -= nums.get(i + 1);
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
