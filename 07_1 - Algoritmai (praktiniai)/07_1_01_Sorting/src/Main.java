public class Main {
  public static void main(String[] args) {
    // write testcode here
    int[] values = {-1, 6, 9, 8, 12};
    System.out.println("Index of the smallest: " + indexOfTheSmallestStartingFrom(values, 1));
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
    int[] slicedArr = new int[array.length - index];
    int j = 0;
    for (int i = index; i < array.length; i++) {
      slicedArr[j] = array[i];
      j++;
    }

    int smallestNum = smallest(slicedArr);

    for (int i = index; i < slicedArr.length; i++) {
      if (slicedArr[i] == smallestNum) return i;
    }
    return -1;
  }
}
