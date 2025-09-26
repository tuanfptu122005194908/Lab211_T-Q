
import java.util.Scanner;

public class DoublyLinkedList {

    Node head, tail;
    public static Scanner sc = new Scanner(System.in);

    public DoublyLinkedList() {
        head = tail = null;
    }

    // check empty
    public boolean isEmpty() {
        return head == null;
    }

    // Nhập 1 số
    public int input() {
        System.out.print("Nhap du lieu info: ");
        return sc.nextInt();
    }

    // Thêm vào đầu
    public void addFirst(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Thêm vào cuối
    public void addLast(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Nhập nhiều số, dừng khi số âm
    public void checkInput() {
        System.out.println("Nhap cac so nguyen duong, nhap so am de ket thuc:");
        while (true) {
            int x = sc.nextInt();
            if (x <= 0) {
                break;
            }
            addLast(x);
        }
    }

    // In danh sách
    public void printList() {
        if (isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        Node tmp = head;
        System.out.print("Danh sach: ");
        while (tmp != null) {
            System.out.print(tmp + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    // Đếm số node
    public void countNode() {
        int cnt = 0;
        Node tmp = head;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        System.out.println("The number of Node in list: " + cnt);
    }

    // Tìm kiếm x
    public int search(int x) {
        Node tmp = head;
        int idx = 0;
        while (tmp != null) {
            if (tmp.info == x) {
                System.out.println("Tim thay " + x + " tai vi tri: " + idx);
                return idx;
            }
            tmp = tmp.next;
            idx++;
        }
        System.out.println("Khong tim thay " + x + " trong danh sach!");
        return -1;
    }
// phuc vu cho cai tim node de addAfter hoac addBefore

    public Node searchPos(int x) { // tra ve cai node dau tien chua x trong danh sach
        Node tmp = head;
        while (tmp != null && tmp.info != x) {
            tmp = tmp.next;
        }
        return tmp;
    }

    // Xoá đầu
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Xoá cuối
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Thêm sau node p
    public void addAfter(Node p, int x) {
        if (p == null) {
            System.err.println("Invalid!");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        newNode.prev = p;
        if (p.next != null) {
            p.next.prev = newNode;
        } else {
            tail = newNode;
        }
        p.next = newNode;
    }

    // Thêm trước node p
    public void addBefore(Node p, int x) {
        if (p == null) {
            System.err.println("Invalid!");
            return;
        }
        if (p == head) {
            addFirst(x);
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p;
        newNode.prev = p.prev;
        p.prev.next = newNode;
        p.prev = newNode;
    }

    // Chèn tại vị trí pos
    public void addPos(int x, int pos) {
        if (pos < 0) {
            System.err.println("Invalid position!");
            return;
        }
        if (pos == 0) {
            addFirst(x);
            return;
        }
        Node tmp = head;
        int idx = 0;
        while (tmp != null && idx < pos) {
            tmp = tmp.next;
            idx++;
        }
        if (tmp == null) {
            addLast(x); // nếu pos >= size thì thêm cuối
        } else {
            addBefore(tmp, x);
        }
    }

    // Xoá node tại vị trí pos
    public void removePos(int pos) {
        if (pos < 0 || isEmpty()) {
            System.out.println("Invalid!");
            return;
        }
        if (pos == 0) {
            removeFirst();
            return;
        }
        Node tmp = head;
        int idx = 0;
        while (tmp != null && idx < pos) {
            tmp = tmp.next;
            idx++;
        }
        if (tmp == null) {
            System.out.println("Position out of range!");
            return;
        }
        if (tmp == tail) {
            removeLast();
        } else {
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }
    }

    // Xoá node sau p
    public void removeAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Khong the xoa (p null hoac p la tail)");
            return;
        }
        Node q = p.next; // node cần xoá
        p.next = q.next;
        if (q.next != null) {
            q.next.prev = p;
        } else {
            tail = p; // nếu xoá tail
        }
        q.prev = q.next = null; // ngắt liên kết để GC xử lý
    }

// Xoá node trước p
    public void removeBefore(Node p) {
        if (p == null || p.prev == null) {
            System.out.println("Khong the xoa (p null hoac p la head)");
            return;
        }
        Node q = p.prev; // node cần xoá
        p.prev = q.prev;
        if (q.prev != null) {
            q.prev.next = p;
        } else {
            head = p; // nếu xoá head
        }
        q.prev = q.next = null; // ngắt liên kết
    }

    // Xoá toàn bộ danh sách
    public void clearList() {
        head = tail = null;
    }
}
