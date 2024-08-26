package programmas.java.lv4;

import java.util.*;

public class 징검다리 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(10);

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("4");
        list2.add("3");
        list2.add("10");
        int[] arr2 = list2.stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(arr2));

        List<int[]> list3 = new ArrayList<>();
        list3.add(new int[]{1, 2});
        list3.add(new int[]{3, 5});
        list3.add(new int[]{1, 1});
        list3.add(new int[]{4, 1});
        list3.sort((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        for (int[] ints : list3) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
