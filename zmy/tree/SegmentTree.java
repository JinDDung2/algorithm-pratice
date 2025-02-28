package zmy.tree;

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // 넉넉한 크기의 트리 배열 생성
        build(arr, 0, 0, n - 1);
    }

    // 세그먼트 트리 초기화 (재귀적 구성)
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start]; // 리프 노드에 원소 저장
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // 구간 합 저장
        }
    }

    // 구간 합 쿼리
    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0; // 범위를 벗어나면 무시
        }
        if (left <= start && end <= right) {
            return tree[node]; // 완전히 포함될 경우 값 반환
        }
        int mid = (start + end) / 2;
        int sumLeft = query(2 * node + 1, start, mid, left, right);
        int sumRight = query(2 * node + 2, mid + 1, end, left, right);
        return sumLeft + sumRight;
    }

    // 값 업데이트: 특정 인덱스의 값을 변경한 후 세그먼트 트리를 갱신
    public void update(int index, int newValue) {
        update(0, 0, n - 1, index, newValue);
    }

    private void update(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            tree[node] = newValue; // 리프 노드 업데이트
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                update(2 * node + 1, start, mid, index, newValue);
            } else {
                update(2 * node + 2, mid + 1, end, index, newValue);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // 부모 노드 갱신
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);

        // [1, 3, 5, 7, 9, 11]에서 구간 합 구하기
        System.out.println(segTree.query(1, 3)); // 3 + 5 + 7 = 15
        System.out.println(segTree.query(2, 5)); // 5 + 7 + 9 + 11 = 32

        // 업데이트 후 다시 쿼리 수행
        segTree.update(2, 10); // arr[2] = 10
        System.out.println(segTree.query(1, 3)); // 3 + 10 + 7 = 20
    }

}
