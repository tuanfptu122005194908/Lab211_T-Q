
import java.util.Scanner;

public class SinglyLinkedList {

    Node head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    }
    public static Scanner sc = new Scanner(System.in);

    // Nhap lieu
    public int input() {
        System.out.println("Nhap du lieu info: ");
        int x = sc.nextInt();
        return x;
    }

    // check xem danh sach co phai la empty khong
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // them vao dau danh sach
    /*
    Cach lam:   tu duy 2 truong hop
    De co the addFirst thi xet:
    1, neu ma danh sach la rong thi ta co head va tail = newNode ( vi no la node duy nhat)
    2, neu danh sach khac rong thi ta se co newNode.next = head  va head update = newNode
     */
    public void addFirst(int x) {
        Node newNode = new Node(x, head);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head = newNode;
        }
    }

    // add last
    /*
    Cach lam:
    xet 2 truong hop
    1 la rong, neu rong thi ca head= tail = newNode
    2 la khac rong, node tiep theo cua tail phai la newNode va cap nhat lai tail = newNode
     */
    public void addLast(int x) {
        Node newNode = new Node(x, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // check input
    /*
    Dung vong lap while true de nhap lien tuc
    neu x<=0 thi break (vi yeu cau nhap so duong)
    con khong thi addlast
     */
    public void checkInput() {
        System.out.println("Nhap cac so nguyen duong, neu nhap so am thi ket thuc:");
        while (true) {
            int x = sc.nextInt();
            if (x <= 0) {
                break;
            } else {
                addLast(x);
            }
        }
    }

    // printList
    /*
    in ra binh thuong thoi
    neu danh sach la rong thi in ra la rong
    neu danh sach khac rong thi duyet tung node tu head den null va in ra
     */
    public void printList() {
        if (isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        Node tmp = head;
        System.out.println("Danh sach: ");
        while (tmp != null) {
            System.out.print(tmp + " ");
            tmp = tmp.next;
        }
        System.out.println();

    }

    // count a number of node in list
    /*
    them bien cnt de dem 
    neu ma rong thi cnt = 0  luon
    neu ma it nhat 1 node thi duyet tung node cap nhat bien cnt roi cho cai tmp = tmp.next de duyet node tiep theo
     */
    public void countNode() {
        int cnt = 0;

        if (isEmpty()) {
            cnt = 0;
        } else {
            Node tmp = head;
            while (tmp != null) {
                cnt++;
                tmp = tmp.next;
            }
        }
        System.out.println("The number of Node in list: " + cnt);
    }

    // tim 1 node co du lieu la x
    public int search(int x) {
        // neu rong thi se khong tim thay
        /*
        tim x nam o vi tri nao
        neu danh sach rong thi khong tim thay
        con neu danh sach ma khac rong thi duyet va dat them bien index neu tmp = x thi return idx con khong tim thay thi lai return 1
         */
        if (isEmpty()) {
            System.out.println("Khong tim thay x!");
            return -1;
        } else {

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
        }
        System.out.println("Khong tim thay " + x + " trong danh sach!");
        return -1;
    }

    // xoa 1 nut o dau danh sach
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        if (head == null) { // danh sach chi co 1 node truoc do
            tail = null;
        }

    }

    // remove node at last of the list
    /*
    Neu rong thi khong lam gi
    neu co 1 node duy nhat thi cho head=tail=null
    neu nhieu hon 1 node thi tim den node gan cai cuoi nhat sau do cho tmp.next = null va cap nhat tail = tmp;
     */
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {  // chi co 1 node duy nhat
            head = tail = null;
            return;
        }
        Node tmp = head;
        while (tmp.next != tail) {
            tmp = tmp.next;
        }
        tmp.next = null;
        tail = tmp;
    }

    // add after
    /*
    Neu p ma la null thi bao loi
    tao 1 newNode voi gia tri la x 
    va next = p.next tuc la Cho node mới trỏ đến cùng node mà p đang trỏ.
    Nếu p.next = 30 thì newNode.next = 30.
    cap nhat p tro sang newNode
    
     */
    public void addAfter(int x, Node p) {
        if (p == null) {
            System.err.println("Invalid");
            return;
        }
        Node newNode = new Node(x, p.next);
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
    }

    // phuc vu cho cai tim node de addAfter hoac addBefore
    public Node searchPos(int x) { // tra ve cai node dau tien chua x trong danh sach
        Node tmp = head;
        while (tmp != null && tmp.info != x) {
            tmp = tmp.next;
        }
        return tmp;
    }

    // add before
    /*
    1. kiem tra danh sach co phai danh sach rong khong neu co thi in ra la danh sach rong
    2. Neu danh sach  ma co Node = head thi ta chi can addFirst
    3. Duyen tu head den cai Prev(dung truoc Node P)
    - vi la khi duyet den cai prev thi can: prev.next!=p  
    ==> neu khong tim thay p thi prev se chay thang den null
    vay: neu prev == null ==> khong tim thay p
    Nguoc lai: neu tim dc p thi tao 1 newNode voi gia tri x va con tro next tro vao p
    cap nhap prev.next = newNode  ( newNode luc nay se nam giua Prev va Node p )
     */
    public void addBefore(int x, Node p) {
        if (isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        if (p == head) {
            addFirst(x);
            return;
        }
        Node prev = head;
        while (prev != null && prev.next != p) {
            prev = prev.next;
        }
        if (prev == null) {
            System.err.println("Can not search node p!");
            return;
        }
        Node newNode = new Node(x, p);
        prev.next = newNode;
    }

    // chen vao vi tri position
    public void addPos(int x, int pos) {
        if (pos < 0) {
            System.err.println("Invalid position");
            return;
        }
        if (pos == 0) {
            addFirst(x);
            return;
        }

        Node tmp = head;
        int idx = 0;
        while (tmp != null && idx < pos - 1) {
            tmp = tmp.next;
            idx++;
        }
        if (tmp.next == null) {
            System.err.println("Position out of range!");
            return;
        }

        Node newNode = new Node(x, tmp.next);
        tmp.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // xoa bo tai vi tri can xoa
    public void removePos(int position) {
        if (position < 0) {
            System.out.println("invalid!");
            return;
        }
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if (position == 0) {
            removeFirst();
            return;
        }

        Node temp = head;
        int index = 0;
        while (temp.next != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }

        // bo node o vi  tri position
        temp.next = temp.next.next;

        // neu ma xoa node cuoi thi cap nhat lai tail
        if (temp.next == null) {
            tail = temp;
        }
    }
    // Xoa node sau node p

    public void removeAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Khong the xoa sau node nay!");
            return;
        }

        Node del = p.next;       // node cần xóa
        p.next = del.next;       // bỏ qua del

        if (del == tail) {       // nếu del là tail thì cập nhật tail mới
            tail = p;
        }
        del.next = null;         // ngắt liên kết
    }

    // Xoa node truoc node p
    public void removeBefore(Node p) {
        if (p == null || p == head) {
            System.out.println("Khong the xoa truoc node nay!");
            return;
        }

        // truong hop p la head.next -> chi can removeFirst
        if (p == head.next) {
            removeFirst();
            return;
        }

        Node prev = head;
        while (prev.next != null && prev.next.next != p) {
            prev = prev.next;
        }

        if (prev.next == null) {
            System.out.println("Khong tim thay node truoc de xoa!");
            return;
        }

        Node del = prev.next;    // node cần xóa
        prev.next = p;           // bỏ qua del
        del.next = null;         // ngắt liên kết
    }

    // Xoa toan bo danh sach
    public void clearList() {
        head = tail = null;
    }
}
