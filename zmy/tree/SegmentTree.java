package zmy.tree;

public class SegmentTree {

    long[] tree; // 각 원소가 담길 트리
    int treeSize; // 트리의 크기

    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    /**
     * @param arr: 원소 배열
     * @param node: 현재 노드
     * @param start: 현재구간 배열 시작
     * @param end: 현재구간 배열 끝
     */
    long init(long[] arr, int node, int start, int end) {
        // 배열의 시작과 끝이 같다면 leaf 노드
        // 원소 배열 그대로 담기
        if (start == end) {
            return tree[node] = arr[start];
        }

        // leaf 노드가 아니면, 자식노드 합 담기
        return tree[node] =
                init(arr, node * 2, start, (start + end) / 2) +
                        init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    /**
     * @param node: 현재 idx
     * @param start: 배열의 시작
     * @param end: 배열의 끝
     * @param idx: 변경된 데이터의 idx
     * @param diff: 원래 데이터 값과 변경 데이터 값의 차이
     */
    void update(int node, int start, int end, int idx, long diff) {
        // 만약 변경할 idx 값이 범위 바깥이면 확인 불필요
        if (idx < start || idx > end) return;

        // 차이를 저장
        tree[node] += diff;

        // 리프노드가 아니면 아래 자식들도 확인
        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    /**
     * @param node: 현재 노드
     * @param start: 배열의 시작
     * @param end: 배열의 끝
     * @param left: 원하는 누적합의 시작
     * @param right:원하는 누적합의 끝
     * @return
     */
    long sum(int node, int start, int end, int left, int right) {
        // 범위를 벗어나게 되는 경우 더할 필요 없음
        if (left > end || right < start) {
            return 0;
        }

        // 범위 내 완전히 포함 시에는 더 내려가지 않고 바로 리턴
        if (left <= start && right >= end) {
            return tree[node];
        }

        // 그 외의 경우 좌/우측 지속 탐색 수행
        return sum(node * 2, start, (start + end) / 2, left, right) +
                sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr.length);

        // 세그먼트 트리 초기화
        segTree.init(arr, 1, 0, arr.length - 1);

        // [1, 3, 5, 7, 9, 11]에서 구간 합 구하기
        System.out.println("SUM(2, 6): " + segTree.sum(1, 0, arr.length - 1, 2, 5)); // 5 + 7 + 9 + 11 = 32

        // 업데이트 후 다시 쿼리 수행
        System.out.println("SUM(3, 6): " + segTree.sum(1, 0, arr.length - 1, 3, 5)); // 3 + 5 + 7 = 27
    }

}
