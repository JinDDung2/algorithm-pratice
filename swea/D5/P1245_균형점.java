package swea.D5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1245_균형점 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            double[] positions = new double[N];
            double[] masses = new double[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                positions[i] = Double.parseDouble(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                masses[i] = Double.parseDouble(st.nextToken());
            }

            System.out.println(Arrays.toString(positions));
            System.out.println(Arrays.toString(masses));

            double[] equilibriumPoints = findEquilibriumPoints(positions, masses);

            result.append("#").append(test_case).append(" ");
            for (double point : equilibriumPoints) {
                result.append(String.format("%.10f ", point));
            }
            result.append("\n");
        }

        System.out.println(result);
    }

    // F = G*m1*m2/(d*d)
    static double[] findEquilibriumPoints(double[] positions, double[] masses) {
        int n = positions.length;
        double[] equilibriumPoints = new double[n - 1];

        for (int i = 0; i < n - 1; i++) {
            double left = positions[i];
            double right = positions[i + 1];

            while (right - left > 1e-12) {
                double mid = (left + right) / 2.0;
                double leftForce = 0.0;
                double rightForce = 0.0;

                for (int j = 0; j < n; j++) {
                    double distance = Math.abs(mid - positions[j]);
                    if (distance > 0) {
                        double force = masses[j] / (distance * distance);
                        if (positions[j] < mid) {
                            leftForce += force;
                        } else {
                            rightForce += force;
                        }
                    }
                }

                if (leftForce < rightForce) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            equilibriumPoints[i] = (left + right) / 2.0;
        }

        return equilibriumPoints;
    }
}
