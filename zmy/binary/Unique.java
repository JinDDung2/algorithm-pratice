package zmy.binary;

public class Unique {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 7;

        int l = find(arr, target);
        System.out.println("l = " + l);
    }

    private static int find(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2; // 10^9

            if (arr[m] == target) {
                return l;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
