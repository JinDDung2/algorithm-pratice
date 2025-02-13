package zmy.divide_conqure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gcd {
    public static void main(String[] args) throws IOException {
        Gcd gcd = new Gcd();
        int result =gcd.solution();
        System.out.println(result);
    }

    int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        return gcd(a, b);
    }

    int gcd (int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
