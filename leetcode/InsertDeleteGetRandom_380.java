package leetcode;

import java.util.*;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class InsertDeleteGetRandom_380 {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public InsertDeleteGetRandom_380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int idx = map.remove(val);
        int last = list.remove(list.size() - 1);
        if (val != last) {
            list.set(idx, last);
            map.put(last, idx);
        }

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
