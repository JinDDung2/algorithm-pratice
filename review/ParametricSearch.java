package review;

public class ParametricSearch {
    // 중복된 값이 있는 배열이나 찾는 값이 없는 상황 -> Parametric Search를 사용

    /**
     * 중복값의 가장 오른쪽이면서 만약 값이없다면 작은값 arr[m] > target, return r
     * 중복값의 가장 오른쪽이면서 만약 값이없다면 큰값 target, return l
     * 중복값의 가장 왼쪽이면서 만약 값이없다면 큰값
     * 중복값의 가장 왼쪽이면서 만약 값이없다면 작은값
     *
     */

    /**
     * 1. 중복값의 가장 오른쪽이면서 만약 값이없다면 작은값 arr[m] > target, return r
     */
    public static int parametricSearch1(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r; // r 반환
    }

    /**
     * 2. 중복값의 가장 오른쪽이면서 만약 값이없다면 큰값 target, return l
     */
    public static int parametricSearch2(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l; // l 반환
    }

    /**
     * 3. 중복값의 가장 왼쪽이면서 만약 값이없다면 큰값
     */
    public static int parametricSearch3(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l; // l 반환
    }

    /**
     * 4. 중복값의 가장 왼쪽이면서 만약 값이없다면 작은값
     */
    public static int parametricSearch4(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r; // r 반환
    }
    public static int parametricSearch(int[] arr, int target) {
        int l = 0, r = arr[arr.length - 1];

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > target) { // 부등호포함에 따라 중복 값중 어느방향 끝값인지 정해짐
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l; // l or r 반환
    }
}
