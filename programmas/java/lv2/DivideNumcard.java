package programmas.java.lv2;

public class DivideNumcard {
    public int solution(int[] arrayA, int[] arrayB) {
        int resultA = getGcdNum(arrayA);
        int resultB = getGcdNum(arrayB);
        // System.out.printf("A=%d, B=%d", resultA, resultB);
        if (!checkNotGcd(resultA, arrayB) && !checkNotGcd(resultB, arrayA))
            return 0;
        else if (checkNotGcd(resultA, arrayB) && !checkNotGcd(resultB, arrayA))
            return resultA;
        else if (!checkNotGcd(resultA, arrayB) && checkNotGcd(resultB, arrayA))
            return resultB;
        else
            return Math.max(resultA, resultB);
    }

    public int gcd(int a, int b) {
        int r = b % a;
        if (r == 0)
            return a;
        return gcd(r, a);
    }

    public int getGcdNum(int[] array) {
        int result = array[0];
        for (int num : array) {
            result = gcd(result, num);
        }
        return result;
    }

    public boolean checkNotGcd(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0)
                return false;
        }
        return true;
    }
}
