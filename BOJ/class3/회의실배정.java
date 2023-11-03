package BOJ.class3;

import java.io.*;
import java.util.*;

// [S1] 1931. 회의실 배정
public class 회의실배정 {
    static List<List<Integer>> room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        room = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> times = new ArrayList<>();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(s);
            times.add(e);
            room.add(times);
        }

        Collections.sort(room, (list1, list2) -> {
            return Integer.compare(list1.get(0), list2.get(0));
        });

        Collections.sort(room, (list1, list2) -> {
            return Integer.compare(list1.get(1), list2.get(1));
        });

        int cnt = 1;
        int end = room.get(0).get(1);
        for (int i = 1; i < room.size(); i++) {
            if (room.get(i).get(0) >= end) {
                end = room.get(i).get(1);
                cnt++;
                // System.out.printf("i=%d, cnt=%d\n", i, cnt);
            }
        }
        System.out.println(cnt);
    }
}
