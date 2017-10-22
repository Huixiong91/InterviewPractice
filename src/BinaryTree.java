import java.util.*;

public class BinaryTree {
    Node root;
    public BinaryTree(int value) {
        this.root = new Node(value);
    }

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class QNode {
        Node node;
        int level;

        public QNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void printTopView() {
        if (root == null) return;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(root, 0));
        while(!queue.isEmpty()) {
            QNode removedItem = queue.remove();
            if(!tm.containsKey(removedItem.level)) tm.put(removedItem.level, removedItem.node.value);

            if(removedItem.node.right != null) { queue.add(new QNode(removedItem.node.right, removedItem.level + 1)); }
            if(removedItem.node.left != null) { queue.add(new QNode(removedItem.node.left, removedItem.level - 1)); }

        }
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printBottomView() {
        if (root == null) return;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(root, 0));
        while(!queue.isEmpty()) {
            QNode removedItem = queue.remove();
            tm.put(removedItem.level, removedItem.node.value);

            if(removedItem.node.right != null) { queue.add(new QNode(removedItem.node.right, removedItem.level + 1)); }
            if(removedItem.node.left != null) { queue.add(new QNode(removedItem.node.left, removedItem.level - 1)); }

        }
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getValue());
        }

    }


    int currentLevel;
    public void printRightView() {
        currentLevel = 0;
        printRightView(root, 1);
    }
    private void printRightView(Node node, int nextLevel) {
        if (node == null) return;

        if(nextLevel > currentLevel) {
            System.out.println(node.value);
            currentLevel++;
        }
        printRightView(node.right, nextLevel + 1);
        printRightView(node.left, nextLevel + 1);
    }

    public void printLeftView() {
        currentLevel = 0;
        printLeftView(root, 1);
    }
    private void printLeftView(Node node, int nextLevel) {
        if (node == null) return;

        if(nextLevel > currentLevel) {
            System.out.println(node.value);
            currentLevel++;
        }
        printLeftView(node.left, nextLevel + 1);
        printLeftView(node.right, nextLevel + 1);
    }

    public void printBFS() {
        if (root == null ) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node removedNode = q.remove();
            System.out.println(removedNode.value);
            if (removedNode.left != null) q.add(removedNode.left);
            if (removedNode.right != null) q.add(removedNode.right);
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(Node node) {
        if (node == null) return;

        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }
    private void printPostOrder(Node node) {
        if (node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    public void printVertically() {
        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        getVerticalLevel(root, hm, 0);

        for (ArrayList<Integer> al : hm.values()) {
            System.out.println(al);
        }
    }

    private void getVerticalLevel(Node node, TreeMap<Integer, ArrayList<Integer>> hm, int level) {
        if (node == null) return;
        if (hm.get(level) == null) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(node.value);
            hm.put(level, al);
        } else {
            hm.get(level).add(node.value);
        }
        getVerticalLevel(node.left, hm, level - 1);
        getVerticalLevel(node.right, hm, level + 1);
    }

    public int findMin() { return findMin(root); }

    private int findMin(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        int current = node.value;
        int minRight = findMin(node.right);
        int minLeft = findMin(node.left);

        return Math.min(Math.min(current, minRight), minLeft);
    }

    public int findMax() { return findMax(root); }

    private int findMax(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int current = node.value;
        int maxRight = findMin(node.right);
        int maxLeft = findMin(node.left);

        return Math.max(Math.max(current, maxRight), maxLeft);
    }

    public boolean isValidBST() { return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); }

    private boolean isValidBST(Node node, int min, int max) {
        if (node == null) return true;
        if (node.value > max || node.value < min) return false;
        return isValidBST(node.left, min, node.value - 1) && isValidBST(node.right, node.value + 1, max);
    }

    public static void main (String[] args) {
        BinaryTree bt = new BinaryTree(8);

		/*
               8
             /   \
            3     10
           / \      \
          1   6      14
             / \
            4   7


        */

        bt.root = new BinaryTree.Node(1);
        bt.root.left = new BinaryTree.Node(2);
        bt.root.right = new BinaryTree.Node(3);
        bt.root.left.left = new BinaryTree.Node(4);
        bt.root.left.right = new BinaryTree.Node(5);
        bt.root.right.left = new BinaryTree.Node(6);
        bt.root.right.right = new BinaryTree.Node(7);
//        bt.root.left.right.left = new Node(4);


        System.out.println("\nTopView...");
        bt.printTopView();
        System.out.println("\nBottomView...");
        bt.printBottomView();
        System.out.println("\nRight view...");
        bt.printRightView();
        System.out.println("\nLeft view...");
        bt.printLeftView();
        System.out.println("\nBFS...");
        bt.printBFS();
        System.out.println("\nPre-order...");
        bt.printPreOrder();
        System.out.println("\nIn-order...");
        bt.printInOrder();
        System.out.println("\nPost-order...");
        bt.printPostOrder();
        System.out.println("\nVertically...");
        bt.printVertically();
        System.out.println("Is valid bst: " + bt.isValidBST());
        System.out.println("\nMax : " + bt.findMax());
        System.out.println("Min : " + bt.findMin());
    }
}
