package review;

public class Gcd {
    public static int gcd(int a, int b) {
        // a > b
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int gcdV2(int i, int j) {
        while (j != 0) {
            int temp = j;
            j = i % j;
            i = temp;
        }
        return i;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // N수의 최대공약수, 최소공배수 구현방법
    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int lcm(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int num1 = 60, num2 = 48;
        int[] arr = {2, 6, 8, 24};
        System.out.println("gcd(num1, num2) = " + gcd(num1, num2));
        System.out.println("lcm(num1, num2) = " + lcm(num1, num2));
        System.out.println("gcd(arr) = " + gcd(arr));
        System.out.println("lcm(arr) = " + lcm(arr));
    }
}
