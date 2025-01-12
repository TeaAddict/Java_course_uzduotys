import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // write testcode here
    int[] values = {8, 3, 7, 9, 1, 2, 4};
    sort(values);
  }

  public static int smallest(int[] array) {
    int smallestNum = array[0];
    for (int el : array) {
      if (el < smallestNum) smallestNum = el;
    }
    return smallestNum;
  }

  public static int indexOfTheSmallest(int[] array) {
    int smallestInt = smallest(array);
    for (int i = 0; i < array.length; i++) {
      if (array[i] == smallestInt) return i;
    }
    return -1;
  }

  public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
    int smallestNum = array[index];
    int smallestIndex = index;
    for (int i = index; i < array.length; i++) {
      if (array[i] < smallestNum) {
        smallestNum = array[i];
        smallestIndex = i;
      }
    }
    return smallestIndex;
  }

  public static void swap(int[] array, int index1, int index2) {
    int oldNum = array[index1];

    array[index1] = array[index2];
    array[index2] = oldNum;
  }

  public static void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int indexOfSmallestNum = indexOfTheSmallestStartingFrom(array, i);
      swap(array, indexOfSmallestNum, i);

      System.out.println(Arrays.toString(array));
    }
  }
}
