public class Main {
    public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    
    list.addAtHead(1);           // [1]
    list.addAtTail(3);           // [1, 3]
    list.addAtIndex(1, 2);       // [1, 2, 3]
    System.out.println(list.get(1));  // Expected: 2
    
    list.deleteAtIndex(1);       // [1, 3]
    System.out.println(list.get(1));  // Expected: 3
}
}