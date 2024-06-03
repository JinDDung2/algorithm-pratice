package review;

public class UnionAndFind {
    static int[] parent;
    public static boolean union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
        y = find(y); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n + 1];
        // 부모 노드 초기화
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        //위의 예제 실행
        union(1, 2);
        union(3, 4);
        union(3, 5);
        System.out.println("find(2): " + find(2));
        System.out.println("find(4): " + find(4));
        System.out.println("find(5) = " + find(5));
        union(2, 4);
        System.out.println("find(3) = " + find(3));
        System.out.println("find(4): " + find(4));
        System.out.println("find(5) = " + find(5));
    }
}
