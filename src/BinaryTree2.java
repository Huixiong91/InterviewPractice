/*
Author : Ng Hui Xiong
Demonstration of different type of binary tree traversal 
 */
import java.util.*;
public class BinaryTree2
{
    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }
    // class for node horizontal level. e.g. root level = 0, root.left = -1, root.right = 1, root.left.left = -2, root.left.right = 0
    static class QItem {
        Node node;
        int level;

        QItem(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    private Node root;

    private void printTopView() {
        if (root == null) return;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        Queue<QItem> q = new LinkedList<>();
        q.add(new QItem(root, 0));
        while(!q.isEmpty()) {
            QItem removedItem = q.remove();
            if(!tm.containsKey(removedItem.level)) tm.put(removedItem.level, removedItem.node.data);

            if (removedItem.node.left != null) q.add(new QItem(removedItem.node.left, removedItem.level - 1));
            if (removedItem.node.right != null) q.add(new QItem(removedItem.node.right, removedItem.level + 1));
        }

        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    /**
     * Prints the tree as if you are looking from the bottom up.
     * Use a treemap to ensure order. That is, we will always print from left to right.
     */
    private void printBottomView() {
        if (root == null) return;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        Queue<QItem> q = new LinkedList<QItem>();
        q.add(new QItem(root, 0));
        while(!q.isEmpty()) {
            QItem removedItem = q.remove();
            tm.put(removedItem.level, removedItem.node.data);

            if (removedItem.node.left != null) q.add(new QItem(removedItem.node.left, removedItem.level - 1));
            if (removedItem.node.right != null) q.add(new QItem(removedItem.node.right, removedItem.level + 1));
        }

        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    private int currentLevel = 0;
    private void printRightView(){
        currentLevel = 0;
        printRightView(root, 1);
    }
    private void printRightView(Node node, int nextLevel) {
        if (node == null) return;

        if (currentLevel < nextLevel) {
            System.out.println(node.data);
            currentLevel = nextLevel;
        }
        printRightView(node.right, nextLevel + 1);
        printRightView(node.left, nextLevel + 1);
    }

    private void printLeftView(){
        currentLevel = 0;
        printLeftView(root, 1);
    }
    private void printLeftView(Node node, int nextLevel) {
        if (node == null) return;

        if (currentLevel < nextLevel) {
            System.out.println(node.data);
            currentLevel = nextLevel;
        }
        printLeftView(node.left, nextLevel + 1);
        printLeftView(node.right, nextLevel + 1);
    }
    private void printPreOrder(){
        printPreOrder(root);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;

        System.out.println(node.data);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }


    private void printBFS(){
        printBFS(root);
    }
    private void printBFS(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        if (node == null) return;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.println(n.data);
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
    private void getVerticalOrder(Node node, int depth) {
        if (node == null) return;

        ArrayList<Integer> currentList = hm.get(depth);

        if (currentList == null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(node.data);
            hm.put(depth, list);
        } else {
            currentList.add(node.data);
        }
        getVerticalOrder(node.left, depth - 1);
        getVerticalOrder(node.right, depth + 1);
    }
    private void printVertically() {
        getVerticalOrder(root, 0);
        for(Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    private int findMax(){
        return findMax(root);
    }
    private int findMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int current = root.data;

        int maxRight = findMax(root.right);
        int maxLeft = findMax(root.left);

        if (maxRight > current) current = maxRight;
        if (maxLeft > current) current = maxLeft;
        return current;
    }


    private int findMin() {
        return findMin(root);
    }
    private int findMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        int current = root.data;

        int maxRight = findMin(root.right);
        int maxLeft = findMin(root.left);

        if (maxRight < current) current = maxRight;
        if (maxLeft < current) current = maxLeft;
        return current;
    }

    private boolean isValidBST() {
        return bstCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean bstCheck(Node node, int min, int max) {
        if (node == null) return true;
        if (node.data < min || node.data > max) return false;
        return (bstCheck(node.left, min, node.data - 1) && bstCheck(node.right, node.data + 1, max));
    }

    public static void main(String[] args)
    {

		/*
               8
             /   \
            3     10
           / \      \
          1   6      14
             / \
            4   7

		 */
        BinaryTree2 bt  = new BinaryTree2();


        bt.root = new Node(8);
        bt.root.left = new Node(3);
        bt.root.right = new Node(10);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(6);
        bt.root.right.right = new Node(14);
        bt.root.left.right.right = new Node(7);
        bt.root.left.right.left = new Node(4);


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
        System.out.println("\nVertically...");
        bt.printVertically();
        System.out.println("Is valid bst: " + bt.isValidBST());
        System.out.println("\nMax : " + bt.findMax());
        System.out.println("Min : " + bt.findMin());
    }
}

