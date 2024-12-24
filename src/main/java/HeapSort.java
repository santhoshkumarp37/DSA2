import java.util.Arrays;

public class HeapSort {
  public static void main(String[] args) {
    int[] arr = { 30, 60, 40, 10, 70, 20, 100, 90};
    System.out.println("Original array:: " + Arrays.toString(arr));
    heapSort(arr);    
  }

  private static void buildHeap(int[] arr) {
    int lastNodeIndex = arr.length - 1;
    for (int i = lastNodeIndex / 2; i >= 0; i--) {
      heapify(arr, i, lastNodeIndex);
    }
    System.out.println("Heapified array:: " + Arrays.toString(arr));
  }

  private static void heapSort(int[] arr) {
    buildHeap(arr);    
    int i = arr.length - 1;
    while (i > 0) {
      swap(arr, 0, i);
      i--;
      heapify(arr, 0, i);
    }
    System.out.println("Sorted array:: " + Arrays.toString(arr));
  }

  private static void swap(int[] arr, int indexPosition1, int indexPosition2) {
    if (indexPosition1 == indexPosition2)
      return;

    int tmp = arr[indexPosition1];
    arr[indexPosition1] = arr[indexPosition2];
    arr[indexPosition2] = tmp;
  }

  private static void heapify(int[] arr, int index, int size) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    int max = index;
    if (left <= size && arr[left] > arr[max]) {
      max = left;
    }
    if (right <= size && arr[right] > arr[max]) {
      max = right;
    }

    if (max != index) {
      swap(arr, max, index);
      heapify(arr, max, size);
    }

  }

}