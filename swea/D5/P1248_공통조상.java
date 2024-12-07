package swea.D5;

import java.io.*;
import java.util.*;

/**
 * 필요한 클래스
 * Node(int v, List<Node> child, Node p)
 * m: 자식추가 하면서 부모 설정해야 함
 * Tree(Node root, Map<Integer, Node> nodes)
 * m: 간선 받아 트리만들기(p, c) -> 루트 설정도 같이(루트가 null이거나 부모값과 같으면?)
 * 최소공통조상찾기(n1, n2) -> n1반복하며 set에 넣고 다음부모로 포인터 변경 후 n2반복하며 최소공통조상
 * 하위서브트리 개수(n1) -> 해당 노드의 하위 리스트들을 재귀순회하며 개수 추가(자기 자신도 1개추가해둬야함)
 * main 출력
 */

public class P1248_공통조상 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Tree tree = new Tree();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            StringTokenizer treeData = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p = Integer.parseInt(treeData.nextToken());
                int c = Integer.parseInt(treeData.nextToken());
                tree.addEdge(p, c);
            }

            Node lowestCommonParent = tree.findLowestCommonParent(num1, num2);
            System.out.printf("#%d %d %d\n", test_case, lowestCommonParent.value, tree.calculateSubtreeSize(lowestCommonParent));
        }
    }

    static class Node
    {
        int value;
        List<Node> children;
        Node parent;

        public Node(int v) {
            this.value = v;
            this.children = new ArrayList<>();
        }

        void addChild(Node node) {
            this.children.add(node);
            node.parent = this;
        }

    }

    static class Tree
    {
        Map<Integer, Node> nodes;
        Node root;

        public Tree() {
            nodes = new HashMap<>();
            root = null;
        }

        // 간선 기반 트리 만들기
        void addEdge(int p, int c) {
            Node parentNode = nodes.computeIfAbsent(p, Node::new);
            Node childNode = nodes.computeIfAbsent(c, Node::new);

            parentNode.addChild(childNode);

            if (root == null || root.value == c) {
                root = parentNode;
            }
        }

        // 공통 조상 찾기
        Node findLowestCommonParent(int v1, int v2) {
            Node n1 = nodes.get(v1);
            Node n2 = nodes.get(v2);

            if (n1 == null || n2 == null) return null;

            Set<Node> parents = new HashSet<>();

            while (n1 != null) {
                parents.add(n1);
                n1 = n1.parent;
            }

            while (n2 != null) {
                if (parents.contains(n2)) return n2;
                n2 = n2.parent;
            }

            return null; // 공통 조상이 없는 경우
        }

        // 하위 서브트리 갯수 구하기
        int calculateSubtreeSize(Node node) {
            if (node == null) return 0;
            int size = 1; // 현재 노드 포함
            for (Node child : node.children) {
                size += calculateSubtreeSize(child);
            }

            return size;
        }
    }
}
