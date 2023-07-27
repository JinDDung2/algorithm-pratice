package leetcode;

public class HitCounter {
    int[] time = new int[300];
    int[] count = new int[300];
    public void hit(int timestamp) {
		// implementation
        int idx = timestamp % 300;
        if (time[idx] != timestamp) {
            time[idx] = timestamp;
            count[idx] = 1;
        } else {
            count[idx]++;
        }
	}

	public int getHits(int timestamp) {
		// implementation
        int cnt = 0;
        for (int i=0; i<300; i++) {
            if (timestamp - time[i] < 300) {
                cnt += count[i];
            }
        }
        return cnt;
	}
}
