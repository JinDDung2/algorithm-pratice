package leetcode;

public class Find_the_Winner_of_an_Array_Game_1535 {
  public int getWinner(int[] arr, int k) {
        
        // k >= arr.length - 1 ? max(arr)
        int max = arr[0];
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                cnt = 1;
            } else {
                cnt++;
            }

            if (cnt == k) {
                return max;
            }
        }

        return max;
    }
}
