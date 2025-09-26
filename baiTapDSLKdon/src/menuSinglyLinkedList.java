
import java.util.Scanner;

public class menuSinglyLinkedList {

    public void showMenuSinglyLinkedList() {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList myList = new SinglyLinkedList();
        while (true) {
            int choice;
            System.out.println("=====Danh sach lien ket don=====");
            System.out.println("1. Nhap du lieu cho danh sach");
            System.out.println("2. Them vao dau danh sach");
            System.out.println("3. Them vao cuoi danh sach");
            System.out.println("4. Xoa bo phan tu dau tien trong danh sach");
            System.out.println("5. Xoa bo phan tu cuoi cung trong danh sach");
            System.out.println("6. Dem so Node trong danh sach");
            System.out.println("7. Them 1 Node vao sau 1 Node");
            System.out.println("8. Them 1 Node vao truoc 1 Node");
            System.out.println("9. Chen Node vao vitri pos");
            System.out.println("10. Xoa node tai vi tri pos");
            System.out.println("11. Xoa toan bo danh sach");
            System.out.println("12. Xoa node sau node p");
            System.out.println("13. Xoa node truoc node p");
            System.out.println("14. In danh sach");
            System.out.println("15. Thoat chuong trinh");

            System.out.println("Your choice: ");
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
                    System.out.println("Gia tri muon them vao Node moi: ");
                    int x = sc.nextInt();
                    Node tmp = myList.searchPos(myList.input());  // Node co gia tri la myList.input()
                    myList.addAfter(x, tmp);  // them sau cai Node ma tim kiem duoc
                    break;

                case 8:
                    System.out.println("Gia tri muon them vao Node moi: ");
                    x = sc.nextInt();
                    tmp = myList.searchPos(myList.input());  // Node co gia tri la myList.input()
                    myList.addBefore(x, tmp);  // them sau cai Node ma tim kiem duoc
                    break;
                case 9:
                    System.out.println("Nhap vi tri muon chen: ");
                    int pos = sc.nextInt();
                    myList.addPos(myList.input(), pos);
                    break;
                case 10:
                    System.out.println("Nhap vi tri muon xoa: ");
                    int pos1 = sc.nextInt();
                    myList.removePos(pos1);
                    break;
                case 11:
                    myList.clearList();
                    System.out.println("Danh sach da duoc xoa!");
                    break;
                case 12:
                    System.out.println("Nhap gia tri Node p de xoa Node sau no: ");
                    int valAfter = sc.nextInt();
                    Node nodeAfter = myList.searchPos(valAfter); // tìm node có giá trị valAfter
                    myList.removeAfter(nodeAfter);
                    break;
                case 13:
                    System.out.println("Nhap gia tri Node p de xoa Node truoc no: ");
                    int valBefore = sc.nextInt();
                    Node nodeBefore = myList.searchPos(valBefore); // tìm node có giá trị valBefore
                    myList.removeBefore(nodeBefore);
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
