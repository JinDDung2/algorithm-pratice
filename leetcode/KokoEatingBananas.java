package leetcode;

// 875. Koko Eating Bananas

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;
        for (int p : piles) {end = Math.max(p, end);}

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (check(mid, piles, h)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean check(int mid, int[] piles, int h) {
        int temp = 0;
        for(int p : piles) {
            temp += p / mid + (p % mid > 0 ? 1: 0);
            if (temp > h) {return false;}
        }
        return true;
    }
}