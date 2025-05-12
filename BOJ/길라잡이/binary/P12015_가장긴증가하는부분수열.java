package BOJ.길라잡이.binary;

import java.io.*;
import java.util.*;

public class P12015_가장긴증가하는부분수열 {

    static class Problem {

        int N;
        int[] arr;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> list = new ArrayList<>();

            for (int num : arr) {
                int idx = lowerBound(list, num);

                if (idx == list.size()) {
                    list.add(num);
                } else {
                    list.set(idx, num);
                }
            }

            bw.write(String.valueOf(list.size()));
            bw.flush();
            bw.close();
            br.close();
        }

        int lowerBound(List<Integer> list, int target) {
            int l = 0, r = list.size();

            while (l < r) {
                int m = l + (r - l) / 2;
                if (list.get(m) < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }

            return l;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
