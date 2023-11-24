package leetcode;

// Pairs of Songs With Total Durations Divisible by 60
public class PairsOfSongsWithTotalDurationsDivisibleBy60_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        // % 60 = 0 -> arr[0] += 1 -> 개수 n(n-1) / 2
        // % 60 != 0 -> arr[time] += 1 -> 개수 arr[time] * arr[60-time]
        // % 60 = 30 -> arr[30] * (arr[30] - 1) / 2
        long ans = 0;
        long[] arr = new long[60];
        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            arr[t] += 1L;
        }

        ans += (arr[0] * (arr[0] - 1) / 2) + (arr[30] * (arr[30] - 1) / 2);

        for (int i = 1; i < 30; i++) {
            ans += (arr[i] * arr[60 - i]);
        }

        return (int) ans;
    }
}
