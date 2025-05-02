package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P2580_스도쿠 {
    static class Problem {

        int[][] data = new int[9][9];
        List<int[]> blanks = new ArrayList<>();
        boolean found = false;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    if (data[i][j] == 0) {
                        blanks.add(new int[]{i, j});
                    }
                }
            }

            solve(0);
        }

        void solve(int idx) {
            if (found) return;

            if (idx == blanks.size()) {
                for (int[] d : data) {
                    for (int num : d) {
                        System.out.printf(num + " ");
                    }
                    System.out.println();
                }
                found = true;
                return;
            }

            int[] blank = blanks.get(idx);
            int x = blank[0], y = blank[1];
            for (int i = 1; i <= 9; i++) {
                if (isValid(x, y, i)) {
                    data[x][y] = i;
                    solve(idx + 1);
                    data[x][y] = 0;
                }
            }
        }

        boolean isValid(int x, int y, int num) {
            for (int i = 0; i < 9; i++) {
                if (data[x][i] == num || data[i][y] == num) return false;
            }

            int startX = (x / 3) * 3, startY = (y / 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (data[startX + i][startY + j] == num) return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
