package programmas.kakao;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT 프렌즈4블록

public class 프렌즈4블록 {
    // 0. String -> char 배열로 바꾸기
    // 1. 보드를 순화하며 4블록 (2*2) 이 된 곳의 좌표를 컬렉션에 모으기 -> list or set
    // 2-1. 컬렉션이 존재하면 -> 길이만큼 블록을 지운다.
    // 2-2. 컬렉션이 존재하지 않으면 -> 메서드 종료
    // 3. 블록을 위에서 아래로 보낸다.
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // 0. String -> char 배열로 바꾸기
        char[][] gameBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            gameBoard[i] = board[i].toCharArray();
        }

        Set<Node> rm = new HashSet<>();

        while (true) {
            // 1. 보드를 순화하며 4블록 (2*2) 이 된 곳의 좌표를 컬렉션에 모으기 -> list or set
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (gameBoard[i][j] == 0)
                        continue;

                    if (gameBoard[i][j] == gameBoard[i + 1][j]
                            && gameBoard[i + 1][j] == gameBoard[i][j + 1]
                            && gameBoard[i][j + 1] == gameBoard[i + 1][j + 1]) {
                        rm.add(new Node(i, j));
                        rm.add(new Node(i + 1, j));
                        rm.add(new Node(i, j + 1));
                        rm.add(new Node(i + 1, j + 1));
                    }
                }
            }

            // 2-2. 컬렉션이 존재하지 않으면 -> 메서드 종료
            if (rm.isEmpty())
                return answer;

            // 2-1. 컬렉션이 존재하면 -> 길이만큼 블록을 지운다.
            answer += rm.size();
            for (Node node : rm) {
                gameBoard[node.y][node.x] = 0;
            }
            System.out.println(rm.size());
            rm.clear();

            // 3. 블록을 위에서 아래로 보낸다. (한 행씩 내려보낸다)
            // 3-1) 현재 값이 있고, 다음 값이 비어있을 경우 내려보낸다.
            boolean isMoved;

            do {
                isMoved = false;
                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n; j++) {
                        if (gameBoard[i][j] != 0 && gameBoard[i + 1][j] == 0) {
                            gameBoard[i + 1][j] = gameBoard[i][j];
                            gameBoard[i][j] = 0;
                            isMoved = true;
                        }
                    }
                }
            } while (isMoved);
        }
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Node node = (Node) obj;
            return Objects.equals(y, node.y) && Objects.equals(x, node.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
