package review.bankpretty;

public class Problem1 {
    // 15m
    public int solution(int[] d, int m) {
        int result = 0;
        int suffix = 0;
        int load = 1;
        for (int i = 0; i < d.length; i++) {
            if (d[i] >= load) {
                suffix += load;
                load *= 2;
            } else {
                load = 1;
            }
            result++;
            if (suffix >= m) break;
        }
        return suffix >= m ? result : -1;
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] arr1 = {1, 3, 2, 5, 4};
        int m1 = 6;
        int[] arr2 = {1, 1, 1, 1, 1};
        int m2 = 6;
        System.out.println("result1 = " + obj.solution(arr1, m1));
        System.out.println("result2 = " + obj.solution(arr2, m2));
    }
}
