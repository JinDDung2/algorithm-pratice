package leetcode;

// 1109. Corporate Flight Bookings
public class CorporateFlightBookings_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 완탐: 2000 * 2000
        // 2000 * 2
        // 시작 mark, 끝 mark
        // 마지막에 for (result[i] += result[i-1])
        int[] result = new int[n];

        for (int[] booking : bookings) {
            int s = booking[0] - 1;
            int e = booking[1];
            int seats = booking[2];

            result[s] += seats;
            if (e < n) {
                result[e] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
