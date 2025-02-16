package zmy;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>((a, b) -> b - a);
        for (int i = 0; i <= 10; i+=2) {
            set.add(i);
            System.out.println("set.contains(i) = " + set.contains(i));
        }
        System.out.println("set = " + set);
        System.out.println("-----------");
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map1.putIfAbsent(i, new HashSet<>());
            Set<Integer> s = map1.get(i);
            for (int j = 1; j <= 5; j++) {
                s.add(i * j);
            }
        }

        System.out.println("map1 = " + map1);
        System.out.println("-----------");

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map2.put(i, map2.getOrDefault(i, 0) + i * i);
        }

        System.out.println("map2 = " + map2);
    }
}
