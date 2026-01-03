package programmas.java.lv2;

// 2025 프로그래머스 코드챌린지 2차 예선 - 서버 증설 횟수
public class NumberOfServerExtensions {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        // 해당 시간에 몇 대의 컴퓨터가 존재해야 하는지
        // 이용자 수 > 컴퓨터 capa면 서버 증설 (단, 증설한 후 k시간 만큼만 해당 서버 이용 가능)
        // 서버 증설 횟수 누적합
        for (int i = 0; i < 24; i++) {
            int people = players[i];
            int currServer = servers[i];
            int addedServer = 0;
            // players <= server * m ? pass
            // players > server * m ? players / m - n -> added sever
            if (people / m > currServer) {
                addedServer += (people / m) - currServer;
                for (int j = 0; j < k; j++) {
                    if (i + j >= 24) continue;
                    servers[i + j] += addedServer;
                }
            }

            answer += addedServer;
        }

        return answer;
    }

    public int anotherSolution(int[] players, int m, int k) {
        int ans = 0;
        int active = 0;
        int[] install = new int[24];

        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                active -= install[i - k];
            }
            int req = players[i] / m;
            if (active < req) {
                int add = req - active;
                ans += add;
                active += add;
                install[i] = add;
            }
        }
        return ans;
    }
}
