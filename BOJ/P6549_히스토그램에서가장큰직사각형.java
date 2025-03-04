package BOJ;

import java.io.*;
import java.util.*;

public class P6549_히스토그램에서가장큰직사각형 {
    static class Problem {
        /**
         * 직사각형의 넓이가 int타입을 넘어갈 수 있음 -> long
         * 스택에 인덱스를 넣으면서, 현재 높이가 top보다 낮다면 pop해서 직사각형 넓이 기존 최댓값과 비교 후 저장
         */
        String solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            StringBuilder sb = new StringBuilder();

            while (!(input = br.readLine()).equals("0")) {
                StringTokenizer st = new StringTokenizer(input);
                int n = Integer.parseInt(st.nextToken()); // 첫 번째 값이 n

                int[] heights = new int[n + 1]; // 마지막에 0을 추가하기 위해 n+1 크기 할당
                for (int i = 0; i < n; i++) {
                    heights[i] = Integer.parseInt(st.nextToken());
                }

                heights[n] = 0; // 마지막 인덱스에 0 추가 (강제 pop 유도)
                sb.append(getLargestRectangle(heights, n)).append("\n");
            }

            return sb.toString();
        }

        long getLargestRectangle(int[] heights, int n) {
            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int currHeight = heights[i];

                while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                    int idx = stack.pop();
                    int h = heights[idx];
                    int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, (long) h * w);
                }

                stack.push(i);
            }

            return maxArea;
        }

        void solutionV2() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input;

            while (!(input = br.readLine()).equals("0")) {
                StringTokenizer st = new StringTokenizer(input);
                int N = Integer.parseInt(st.nextToken());
                long[] heights = new long[N];
                for (int i = 0; i < N; i++) {
                    heights[i] = Long.parseLong(st.nextToken());
                }

                SegmentTree segmentTree = new SegmentTree(heights.length);
                segmentTree.init(heights, 1, 0, heights.length - 1);
                bw.write(segmentTree.getMaxArea(heights, 0, N - 1) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }

    static class SegmentTree {
        int[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new int[treeSize];
        }

        int init(long[] heights, int node, int start, int end) {
            if (start == end) return tree[node] = start;

            int mid = (start + end) / 2;
            int leftIdx = init(heights, node * 2, start, mid);
            int rightIdx = init(heights, node * 2 + 1, mid + 1, end);

            return tree[node] = (heights[leftIdx] <= heights[rightIdx]) ? leftIdx : rightIdx;
        }

        // 구간 내 최소 높이 인덱스 찾기
        int query(long[] heights, int node, int start, int end, int left, int right) {
            if (left > end || right < start) return -1;
            if (left <= start && end <= right) return tree[node];

            int mid = (start + end) / 2;
            int leftIdx = query(heights, node * 2, start, mid, left, right);
            int rightIdx = query(heights, node * 2 + 1, mid + 1, end, left, right);

            if (leftIdx == -1) return rightIdx;
            if (rightIdx == -1) return leftIdx;
            return (heights[leftIdx] <= heights[rightIdx]) ? leftIdx : rightIdx;
        }

        long getMaxArea(long[] heights, int left, int right) {
            if (left > right) return 0;

            int minIdx = query(heights, 1, 0, heights.length - 1, left, right);
            long area = heights[minIdx] * (right - left + 1);

            long leftArea = getMaxArea(heights, left, minIdx - 1);
            long rightArea = getMaxArea(heights, minIdx + 1, right);

            return Math.max(
                    area, Math.max(leftArea, rightArea)
            );
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
//        System.out.println(p.solution());
        p.solutionV2();
    }
}
