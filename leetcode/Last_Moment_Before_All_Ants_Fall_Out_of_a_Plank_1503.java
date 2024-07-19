package leetcode;

class Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank_1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;

        for (int l : left) {
            max = Math.max(max, l);
        }

        for (int r : right) {
            max = Math.max(max, n - r);
        }

        return max;
    }
}
