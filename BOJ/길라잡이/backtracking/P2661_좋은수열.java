package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P2661_좋은수열 {
    static class Problem {

        int N;
        boolean found = false;

        void solution() throws IOException {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            dfs("");
        }

        void dfs(String str) {
            if (found) return;

            if (str.length() == N) {
                System.out.println(str);
                found = true;
                return;
            }

            for (char c = '1'; c <= '3'; c++) {
                if (isGood(str + c)) {
                    dfs(str + c);
                }
            }
        }

        boolean isGood(String str) {
            int len = str.length();
            for (int i = 1; i <= len / 2; i++) {
                String left = str.substring(len - 2 * i, len - i);
                String right = str.substring(len - i);

                if (left.equals(right)) return false;
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
