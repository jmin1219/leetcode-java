public class MyLinkedList {
  // 1. Declare Member Variables
  // private modifer for encapsulation = only accessible within this class (similar to self._head in Python)
  private ListNode head;
  private int size;

  // 2. Constructors
  MyLinkedList() {
    head = null;
    size = 0;
  }

  public int get(int index) {
    // 1. Bounds check -> return -1 if invalid
    if (index < 0 || index >= size) {
      return -1;
    }

    // 2. Traverse to the node at 'index'
    ListNode curr = head;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }

    // 3. Return that node's value
    return curr.val;
  }

  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);
    newNode.next = head;
    head = newNode;
    size++;
  }

  public void addAtTail(int val) {    
    ListNode newNode = new ListNode(val);

    if (head == null) {
      head = newNode;
    } else { 
      ListNode curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = newNode;
    }

    size++;
  }

  public void addAtIndex(int index, int val) {
    // 1. Invalid bounds -> return
    if (index > size || index < 0) { 
      return;
    }
    
    // 2. index == 0 -> add at head
    if (index == 0) {
      addAtHead(val);
      return;
    }
    
    // 3. index == size -> add at tail
    if (index == size) {
      addAtTail(val);
      return;
    }
    
    // 4. Middle insertion: traverse to (index - 1), then splice.
    ListNode curr = head;
    for (int i = 0; i < index - 1; i++) {
      curr = curr.next;
    }
    
    ListNode newNode = new ListNode(val);
    newNode.next = curr.next;
    curr.next = newNode;
    size++;
  }

  public void deleteAtIndex(int index) {
    // 1. Invalid bounds -> return
    if (index < 0 || index >= size) {
      return;
    }

    // 2. index == 0 -> move head to head.next
    if (index == 0) {
      head = head.next;
      size--;
      return;
    }

    // 3. Middle deletion: traverse to (index - 1), then skip over curr
    ListNode curr = head;
    for (int i = 0; i < index - 1; i++) {
      curr = curr.next;
    }
    curr.next = curr.next.next;
    size--;
  }
}
