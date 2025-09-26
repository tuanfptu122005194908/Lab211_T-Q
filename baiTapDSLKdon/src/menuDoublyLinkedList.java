import java.util.Scanner;

public class menuDoublyLinkedList {

    public void showMenuDoublyLinkedList() {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList myList = new DoublyLinkedList();
        while (true) {
            int choice;
            System.out.println("===== DANH SACH LIEN KET KEP =====");
            System.out.println("1. Nhap du lieu cho danh sach");
            System.out.println("2. Them vao dau danh sach");
            System.out.println("3. Them vao cuoi danh sach");
            System.out.println("4. Xoa bo phan tu dau tien");
            System.out.println("5. Xoa bo phan tu cuoi cung");
            System.out.println("6. Dem so Node trong danh sach");
            System.out.println("7. Them 1 Node vao sau 1 Node");
            System.out.println("8. Them 1 Node vao truoc 1 Node");
            System.out.println("9. Chen Node vao vi tri pos");
            System.out.println("10. Xoa Node tai vi tri pos");
            System.out.println("11. Xoa Node sau 1 Node");
            System.out.println("12. Xoa Node truoc 1 Node");
            System.out.println("13. Xoa toan bo danh sach");
            System.out.println("14. In danh sach tu head -> tail");
            System.out.println("15. Thoat MENU");

            System.out.print("Your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myList.checkInput();
                    break;
                case 2:
                    myList.addFirst(myList.input());
                    break;
                case 3:
                    myList.addLast(myList.input());
                    break;
                case 4:
                    myList.removeFirst();
                    break;
                case 5:
                    myList.removeLast();
                    break;
                case 6:
                    myList.countNode();
                    break;
                case 7:
                    System.out.print("Gia tri muon them vao Node moi: ");
                    int x = sc.nextInt();
                    System.out.print("Nhap gia tri Node p: ");
                    int key1 = sc.nextInt();
                    Node p1 = myList.searchPos(key1); // tim node có info = key1
                    myList.addAfter(p1, x);
                    break;
                case 8:
                    System.out.print("Gia tri muon them vao Node moi: ");
                    x = sc.nextInt();
                    System.out.print("Nhap gia tri Node p: ");
                    int key2 = sc.nextInt();
                    Node p2 = myList.searchPos(key2);
                    myList.addBefore(p2, x);
                    break;
                case 9:
                    System.out.print("Nhap vi tri muon chen: ");
                    int pos = sc.nextInt();
                    myList.addPos(myList.input(), pos);
                    break;
                case 10:
                    System.out.print("Nhap vi tri muon xoa: ");
                    int pos1 = sc.nextInt();
                    myList.removePos(pos1);
                    break;
                case 11:
                    System.out.print("Nhap gia tri Node p: ");
                    int key3 = sc.nextInt();
                    Node p3 = myList.searchPos(key3);
                    myList.removeAfter(p3);
                    break;
                case 12:
                    System.out.print("Nhap gia tri Node p: ");
                    int key4 = sc.nextInt();
                    Node p4 = myList.searchPos(key4);
                    myList.removeBefore(p4);
                    break;
                case 13:
                    myList.clearList();
                    System.out.println("Danh sach da duoc xoa!");
                    break;
                case 14:
                    myList.printList();
                    break;
                case 15:
                    System.out.println("Exit MENU!");
                    return;
                default:
                    System.out.println("Invalid selection, please try again!");
            }
        }
    }
}
