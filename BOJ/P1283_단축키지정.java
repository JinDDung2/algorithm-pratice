package BOJ;

import java.io.*;
import java.util.*;

public class P1283_단축키지정 {

    // 1. 띄어쓰기 기준 split -> 각 문자열의 첫 문자만 비교(set)
    // 1-1) 1번에서 찾았으면 -> set 추가 + 해당 인덱스 저장
    // 1-2) 1번에서 못찾았다면 -> 모든 문자열 비교 후 set 추가 + 해당 인덱스 저장
    // 1-3) 문자열의 모든 char가 새로운 알파벳이 아니라면 문자열 그대로 저장
    // 2. 출력용 값 sb에 값 넣기
    // wrapInBracket = "[" + 해당 문자 + "]"
    // 빈칸처리는? 문자열 값이 알파벳일때만 set 확인하자.
    // set에는 lowerCase만 넣기

    static class Problem {

        int N;

        void solution() throws IOException {
            // 데이터 입력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            Set<Character> set = new HashSet<>();
            StringBuilder result = new StringBuilder();

            while (N-- > 0) {
                // 옵션 문자열 받기
                String input = br.readLine().strip();
                String[] inputSplit = input.split("\\s+");
                int newAlphabetIdx = -1;
                int currIdx = 0;

                // 공백만 있을 경우
                if (input.isBlank()) {
                    result.append(input).append("\n");
                    continue;
                }
                // 각 문자열의 첫문자부터 set과 비교
                for(String str : inputSplit) {
                    char firstChar = str.charAt(0);
                    char lowerC = Character.toLowerCase(firstChar);
                    if (!set.contains(lowerC)) {
                        set.add(lowerC);
                        newAlphabetIdx = currIdx;
                        break;
                    }

                    currIdx += str.length() + 1; // 띄어쓰기 고려
                }

                // 모든 문자와 set 비교
                if (newAlphabetIdx == -1) {
                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);
                        if (c == ' ') continue; // 공백은 패스
                        char lowerC = Character.toLowerCase(c);
                        if (!set.contains(lowerC)) {
                            set.add(lowerC);
                            newAlphabetIdx = i;
                            break;
                        }
                    }
                }

                // 첫문잦열이 있다면 괄호로 래핑, 없다면 그대로 넣기
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    result.append(i == newAlphabetIdx ? wrapInBracket(c) : c);
                }
                result.append("\n");
            }

            System.out.println(result);
        }

        String wrapInBracket(final char c) {
            return "[" + c + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        p.solution();
    }
}
