package programmas.java.lv3;

// 징검다리 건너기
class SteppingOverSteppingStone {
    public int solution(int[] stones, int k) {
        int max = 0;

        for (int i = 0; i < stones.length; i++) {
            if (max < stones[i])
                max = stones[i];
        }

        // 넘어간 사람 수 이진탐색
        int l = 1;
        int r = max;

        // stones 안의 값이 1개일 때
        if (stones.length == 1)
            return stones[0];

        while (l < r - 1) {
            int mid = (l + r) / 2;
            boolean check = checkMid(stones, k, mid);
            if (check) {
                l = mid;
            } else {
                r = mid;
            }
            // System.out.printf("l = %d, r = %d m = %d check=%b \n", l, r, mid, check);
        }

        return l;
    }

    public boolean checkMid(int[] stones, int k, int mid) {
        int now = 0;
        for (int s : stones) {
            if (s < mid) {
                now += 1;
            } else {
                now = 0;
            }

            if (now >= k) {
                return false;
            }
        }
        return true;
    }
}