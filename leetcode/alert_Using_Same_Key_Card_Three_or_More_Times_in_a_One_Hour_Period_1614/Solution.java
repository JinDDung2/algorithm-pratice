package leetcode.alert_Using_Same_Key_Card_Three_or_More_Times_in_a_One_Hour_Period_1614;

import java.util.*;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(toMin(time));
        }

        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);

            if (times.size() < 3) continue;
            int s = 0;
            int e = 2;

            while (e < times.size()) {
                int temp = times.get(e++) - times.get(s++);
                if (temp <= 60) {
                    result.add(name);
                    break;
                }
            }
        }
        Collections.sort(result);

        return result;
    }

    int toMin(String str) {
        String[] arr = str.split(":");
        return 60 * Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
    }
}
