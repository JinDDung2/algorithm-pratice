package BOJ.greedy_implemention;

import java.io.*;
// [S3] 오리
public class Duck12933 {
    private final char[] QUACK = {'q', 'u', 'a', 'c', 'k'};
    private int cnt = 0;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[arr.length];

        if (arr.length % 5 != 0) {
            System.out.println(-1);
            return;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 'q' && !visited[i]) {
                findDuck(i, arr, visited);
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);


    }
    private void findDuck(int start, char[] arr, boolean[] visited) {
        int j = 0;
        boolean flag = true;
        for (int i=start; i<arr.length; i++) {
            if (arr[i] == QUACK[j] && !visited[i]) {
                visited[i] = true;
                if (arr[i] == 'k') {
                    j = 0;
                    if (flag) {
                        cnt++;
                        flag = false;
                    }
                }
                else {
                    j++;
                }
                
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Duck12933().solution();
    }
}