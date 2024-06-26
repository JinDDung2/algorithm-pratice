package leetcode;

public class Find_the_Highest_Altitude_1732 {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int prefix = 0;
        for (int g : gain) {
            prefix += g;
            result = Math.max(result, prefix);
        }

        return result;
    }
}
