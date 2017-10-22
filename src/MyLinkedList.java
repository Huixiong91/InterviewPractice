import java.util.HashSet;

public class MyLinkedList {
    static class Node {
        Node next;
        int data;

        public Node(int val) {
            this.data = val;
        }
    }

    Node head;

    public MyLinkedList(int val) {
        this.head = new Node(val);
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ">");
            current = current.next;
        }
        System.out.println();
    }

    public void add(int val) {
        Node current = head;
        while (current.next!=null) current = current.next;
        current.next = new Node(val);
    }

    public void remove(int val) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current!=null) {
            count++;
            current=current.next;
        }
        return count;
    }

    public void reverse() {
    /* iterative solution */
        Node newHead = null;
        Node current = head;
        while (current !=null) {
            Node next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        head = newHead;
    }

    public Node getMid() {
        Node fast = head;
        Node slow = head;
        while (fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node findCommonNode(MyLinkedList list1, MyLinkedList list2) {
        HashSet<Node> hs = new HashSet<>();
        Node c1 = list1.head;
        while (c1 != null) {
            hs.add(c1);
            c1 = c1.next;
        }
        Node c2 = list2.head;
        while (c2 != null) {
            if (hs.contains(c2)) return c2;
            c2 = c2.next;
        }
        return null;
    }

    public static Node findCommonNode2(MyLinkedList list1, MyLinkedList list2) {
        int count1 = list1.size();
        int count2 = list2.size();
        int diff = Math.abs(count1 - count2);

        Node c1 = list1.head;
        Node c2 = list2.head;
        if (count1 > count2) {
            while(diff > 0) {
                c1 = c1.next;
                diff--;
            }
        } else{
            while(diff > 0) {
                c2 = c2.next;
                diff--;
            }
        }

        while (c1 != null && c2 != null) {
            if (c1 == c2) return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList(5);
        list1.add(6);

        MyLinkedList list2 = new MyLinkedList(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
//        list2.head.next.next = list1.head;
        list2.print();
        list2.reverse();
        list2.print();
//        list1.print();
        System.out.println("Mid node: " + list2.getMid().data);
        Node commonNode = findCommonNode2(list1, list2);
        if (commonNode != null)
            System.out.println("Common Node val: " + commonNode.data);
        else
            System.out.println("No commonNode");
    }

}
