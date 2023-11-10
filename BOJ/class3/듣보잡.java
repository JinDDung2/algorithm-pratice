package BOJ.class3;

import java.io.*;
import java.util.*;

// [S4] 1764. 듣보잡
public class 듣보잡 {
    private static String[] arr;
    private static Map<String, Boolean> map;
    private static List<String> result;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new String[N];
        map = new HashMap<>();
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), true);
        }

        for (int i = 0; i < N; i++) {
            String str = arr[i];
            if (map.containsKey(str)) {
                cnt++;
                result.add(str);
            }
        }

        System.out.println(cnt);
        for (String str : result) {
            System.out.println(str);
        }

        br.close();
    }
}
