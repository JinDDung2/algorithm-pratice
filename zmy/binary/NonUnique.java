package zmy.binary;

public class NonUnique {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 7, 8};
        int target = 7;

        int lower = findLower(arr, target);
        System.out.println("lower = " + lower);

        int upper = findUpper(arr, target);
        System.out.println("upper = " + upper);
    }

    private static int findLower(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int findUpper(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
