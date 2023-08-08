package leetcode;

import java.util.*;

// try 1

class SnapshotArray {
    TreeMap<Integer, Integer>[] map;
    int curSnap;

    public SnapshotArray(int length) {
        curSnap = 0;
        map = new TreeMap[length];
        for (int i=0; i<length; i++) {
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(curSnap, val);
    }
    
    public int snap() {
        return this.curSnap++;
    }
    
    public int get(int index, int snap_id) {
        return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */