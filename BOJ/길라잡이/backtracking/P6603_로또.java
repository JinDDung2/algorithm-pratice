package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P6603_로또 {
    /**
     * 가능한 모든 경우의 수 kC6. k < 13. 최악 O(12C6)
     */
    static class Problem {
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String input = null;
            while (!(input = br.readLine()).equals("0")) {
                StringTokenizer st = new StringTokenizer(input);
                int k = Integer.parseInt(st.nextToken());
                int[] arr = new int[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());;
                }
                List<List<Integer>> result = new ArrayList<>();
                backtracking(arr, 0, k, new ArrayList<>(), result);

                for (List<Integer> list : result) {
                    for (int num : list) {
                        bw.write(String.valueOf(num) + " ");
                    }
                    bw.write("\n");
                }
                bw.write("\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        void backtracking(int[] arr, int start, int maxSize, List<Integer> temp, List<List<Integer>> result) {
            if (temp.size() == 6) {
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i < maxSize; i++) {
                temp.add(arr[i]);
                backtracking(arr, i + 1, maxSize, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
