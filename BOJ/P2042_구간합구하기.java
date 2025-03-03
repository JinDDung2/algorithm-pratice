package BOJ;

import java.io.*;
import java.util.*;

public class P2042_구간합구하기 {

    static class Problem {
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }

            // 세그먼트 트리 생성 및 초기화
            Segment segmentTree = new Segment(N);
            segmentTree.init(arr, 1, 0, N - 1);

            for (int i = 0; i < M + K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a == 1) { // 값 업데이트 (1-based -> 0-based 변환 필요)
                    long c = Long.parseLong(st.nextToken());
                    segmentTree.update(1, 0, N - 1, b - 1, c - arr[b - 1]);
                    arr[b - 1] = c; // 원래 배열 값도 업데이트
                } else { // 구간 합 구하기 (1-based -> 0-based 변환)
                    int c = Integer.parseInt(st.nextToken());
                    bw.write(segmentTree.sum(1, 0, N - 1, b - 1, c - 1) + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }

    static class Segment {
        long[] tree;
        int treeSize;

        public Segment(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        long init(long[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];

            int mid = (start + end) / 2;
            return tree[node] =
                    init(arr, node * 2, start, mid) +
                            init(arr, node * 2 + 1, mid + 1, end);
        }

        long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) return 0; // 범위를 벗어나면 0 반환
            if (left <= start && end <= right) return tree[node]; // 완전히 포함된 경우 반환

            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right) +
                    sum(node * 2 + 1, mid + 1, end, left, right);
        }

        void update(int node, int start, int end, int idx, long diff) {
            if (start > end || idx < start || idx > end) return; // 범위를 벗어난 경우 리턴

            tree[node] += diff; // 변화량 적용

            if (start != end) { // 리프 노드가 아닐 경우, 자식 노드도 갱신
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        p.solution();
    }
}
