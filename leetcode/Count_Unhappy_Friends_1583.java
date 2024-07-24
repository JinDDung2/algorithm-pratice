package leetcode;

public class Count_Unhappy_Friends_1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] partnerRank = new int[n];

        for (int[] pair : pairs) {
            int i = pair[0];
            int j = pair[1];
            partnerRank[i] = indexOf(preferences[i], j);
            partnerRank[j] = indexOf(preferences[j], i);
        }

        // System.out.println(Arrays.toString(partnerRank));
        int unHappyPeople = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < partnerRank[i]; j++) {
                int partner = preferences[i][j];
                if (partnerRank[partner] > indexOf(preferences[partner], i)) {
                    unHappyPeople++;
                    break;
                }
            }
        }

        return unHappyPeople;
    }

    private int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
}
