package programmas.java.lv2;

public class NormalSquare {
    public long solution(int w, int h) {
        if (w < h) {
            int temp = w;
            w = h;
            h = temp;
        }
        int num = gcd(w, h);
        int ww = w / num;
        int hh = h / num;
        int cut = (ww * hh - (ww - 1) * (hh - 1));
        long answer = (w * h) - (num * cut);
        return answer;
    }

    public int gcd(int a, int b) {
        int r = b % a;
        if (r == 0)
            return a;
        return gcd(r, a);
    }

    public static void main(String[] args) {
        long n = new NormalSquare().solution(99999999, 100000000);
        System.out.println(n);
    }
}
