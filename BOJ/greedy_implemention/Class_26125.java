package BOJ.greedy_implemention;

import java.io.*;
import java.util.*;
// [S3] 눈 치우기
public class Class_26125 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.valueOf(br.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        int result = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.valueOf(st.nextToken());
            data[idx] = num;
            idx++;
        }

        int max_data = 0;
        int sum_data = 0;

        for (int i =0; i<N-1; i++) {
            sum_data += data[i];
            if (data[i] < data[i+1]) {
                max_data = data[i+1];
            }
        }
        if (N == 1) {
            max_data = data[0];
        }
        sum_data += data[N-1];
    
        if (max_data >= (sum_data - max_data)) {
            result = max_data;
        } else {
            result = (int) (Math.ceil(sum_data / 2));
        }

        if (result > 1440) {
            result = -1;
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException{
        new Class_26125().solution();
    }
}
