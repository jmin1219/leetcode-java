package heaps;

import java.util.ArrayList;

public class MyHeap {
  private ArrayList<Integer> arr;

  public MyHeap() {
    arr = new ArrayList<>();
  }

  public void insert(int val) {
    arr.add(val);
    bubbleUp(arr.size() - 1);
  }

  public Integer extractMax() {
    if (arr.isEmpty()) return null;

    Integer max = arr.get(0);
    arr.set(0, arr.get(arr.size() - 1));
    arr.remove(arr.size() - 1);
    if (!arr.isEmpty()) bubbleDown(0);
    return max;
  }

  public Integer peek() {
    if (arr.isEmpty()) return null;
    return arr.get(0);
  }

  public int size() {
    return arr.size();
  }

  // ============ Private Helpers ============

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int leftChild(int i) {
    return 2 * i + 1;
  }

  private int rightChild(int i) {
    return 2 * i + 2;
  }

  private void swap(int i, int j) {
    Integer temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  private void bubbleUp(int i) {
    while (i > 0 && arr.get(i) > arr.get(parent(i))) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  private void bubbleDown(int i) {
    while (leftChild(i) < arr.size()) {
      int left = leftChild(i);
      int right = rightChild(i);
      int largest = left;

      if (right < arr.size() && arr.get(right) > arr.get(left)) {
        largest = right;
      }

      if (arr.get(i) >= arr.get(largest)) {
        break;
      }

      swap(i, largest);
      i = largest;
    }
  }
}
