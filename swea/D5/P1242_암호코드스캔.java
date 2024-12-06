package swea.D5;

import java.util.*;
import java.io.*;

public class P1242_암호코드스캔 {

    final Map<String, Integer> HEX_TO_BINARY = Map.of(
            "A", 10,
            "B", 11,
            "C", 12,
            "D", 13,
            "E", 14,
            "F", 15
    );

    final Map<String, Integer> CODE_MAP = Map.of(
            "0001101", 0,
            "0011001", 1,
            "0010011", 2,
            "0111101", 3,
            "0100011", 4,
            "0110001", 5,
            "0101111", 6,
            "0111011", 7,
            "0110111", 8,
            "0001011", 9
    );

    Set<String> visited = new HashSet<>();
    List<String> codeLines = new ArrayList<>();
    int N, M, T;

    public static void main(String[] args) throws IOException {
        P1242_암호코드스캔 s = new P1242_암호코드스캔();
        s.solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer arrLength = new StringTokenizer(br.readLine());
            N = Integer.parseInt(arrLength.nextToken());
            M = Integer.parseInt(arrLength.nextToken());

            Set<String> uniqueRows = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String row = br.readLine().strip();
                uniqueRows.add(row.replaceAll("0+$", ""));
            }
            System.out.println(uniqueRows);

            codeLines.addAll(uniqueRows);
            System.out.printf("#%d %d\n", test_case, searchCode());
        }
    }

    public int searchCode() {
        int total = 0;

        for (int i = 0; i < codeLines.size(); i++) {
            codeLines.set(i, hexToBinary(codeLines.get(i)));

            while (!codeLines.get(i).isEmpty()) {
                CodeStatus status = findCodeStatus(i);
                int e = status.getEnd();
                int width = status.getWidth();

                String binary = extractCode(codeLines.get(i), e, width);

                if (!visited.contains(binary)) {
                    total += solveCode(binary);
                    visited.add(binary);
                }

                codeLines.set(i, cleanCode(codeLines.get(i), e, width));
            }
        }

        return total;
    }

    CodeStatus findCodeStatus(int i) {
        String row = codeLines.get(i);
        int cnt = 0, e = 0;
        char current = '0';
        int change = 0;

        for (int j = row.length() - 1; j >= 0; j--) {
            if (row.charAt(j) != current) {
                if (change == 4) break;
                change++;
                current = row.charAt(j);
            }

            if (row.charAt(j) == '1') {
                if (cnt == 0) e = j;
                cnt++;
            } else if (cnt > 0) {
                cnt++;
            }
        }

        int width = cnt / 7;
        return new CodeStatus(e, width);
    }

    String extractCode(String row, int e, int width) {
        StringBuilder binary = new StringBuilder();
        for (int i = e - 56 * width + 1; i <= e; i += width) {
            binary.append(row.charAt(i));
        }
        return binary.toString();
    }

    String cleanCode(String row, int e, int width) {
        return row.substring(0, e - 56 * width + 1).replaceAll("0+$", "");
    }

    int solveCode(String code) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            String segment = code.substring(i * 7, (i + 1) * 7);
            result.add(CODE_MAP.get(segment));
        }
        System.out.println("result = " + result);

        int oddSum = 0, evenSum = 0;
        for (int i = 0; i <= 7; i++) {
            if (i % 2 == 1) {
                oddSum += result.get(i);
            } else {
                evenSum += result.get(i);
            }
        }

        if ((oddSum * 3 + evenSum) % 10 == 0) {
            return result.stream().mapToInt(Integer::intValue).sum();
        }
        return -1;
    }

    static class CodeStatus {
        int end;
        int width;

        public CodeStatus(int end, int width) {
            this.end = end;
            this.width = width;
        }

        int getEnd() {
            return end;
        }

        int getWidth() {
            return width;
        }
    }

    String tenToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }

    String hexToBinary(String hex) {
        StringBuilder binary = new StringBuilder();
        for (char c : hex.toCharArray()) {
            if (Character.isDigit(c)) {
                binary.append(tenToBinary(Character.getNumericValue(c)));
            } else {
                binary.append(tenToBinary(HEX_TO_BINARY.get(String.valueOf(c))));
            }
        }
        System.out.println("binary = " + binary);
        return binary.toString();
    }

}
