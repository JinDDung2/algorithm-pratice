package BOJ.greedy_implemention;

import java.io.*;
import java.util.*;

// [G5] 달력
public class Class_20207 {
    static final int DAY_OF_YEAR = 365;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] dates = new int[DAY_OF_YEAR+1];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            for (int i=s; i<=e; i++) {
                dates[i]++;
            }
        }

        int w = 0;
        int h = 0;
        int result = 0;

        for (int i=0; i<dates.length; i++) {
            if (dates[i] == 0) {
                result += (w * h);
                w = 0;
                h = 0;
                continue;
            }
            w++;
            h = Math.max(h, dates[i]);
        }
        // 마지막 날이 0이 아닐수 있으니
        result += (w * h);
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException{
        new Class_20207().solution();
    }
}
