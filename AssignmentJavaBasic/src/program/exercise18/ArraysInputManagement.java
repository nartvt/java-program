package  program.exercise18;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysInputManagement {

  private Scanner sc;
  private int[] arrays;

  public ArraysInputManagement() {
    super();
    this.sc = new Scanner(System.in);
  }

  public void setArrays(int n, int[] arrays) {
    this.arrays = new int[n];
  }

  public int[] getArrays() {
    return arrays;
  }

  public void closeScanner() {
    if (sc.hasNext()) {
      sc.close();
    }
  }

  public int menu() {
    System.out.println("\n===== Arrays Example =====");
    System.out.println("1. Input Value");
    System.out.println("2. Prinf All Arrays");
    System.out.println("3. Calculator Avg value ");
    System.out.println("4. Find Min,Max Value ");
    System.out.println("5. Find Min,Max Value under Zero");
    System.out.println("6. Find Min,Max Value over Zero");
    System.out.println("7. Find even, odd number ");
    System.out.println("8. Add element  by index ");
    System.out.println("9. Remove element by index");
    System.out.println("10. Exit program");
    System.out.print("Choose: ");
    int option = Integer.valueOf(sc.nextLine());
    return option;
  }

  private void inputArrays(final int n, final int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      System.out.printf("arrays[%d]: ", i);
      arrays[i] = Integer.valueOf(sc.nextLine());
    }
  }

  private void printArrays(final int[] arrays) {
    for (int i : arrays) {
      System.out.printf("%d ", i);
    }
  }

  private float calAvg(final int[] arrays) {
    int total = 0;
    for (int i : arrays) {
      total += i;
    }
    float length = arrays.length;
    return (total / length);
  }

  private int minValue(final int[] arrays) {
    int min = arrays[0];
    for (int i : arrays) {
      if (min > i) {
        min = i;
      }
    }
    return min;
  }

  private int maxValue(final int[] arrays) {
    int max = arrays[0];
    for (int i : arrays) {
      if (max < i) {
        max = i;
      }
    }
    return max;
  }

  private int maxValueUnderZero(final int[] arrays) {
    int max = Integer.MIN_VALUE;
    for (int i : arrays) {
      if (i < 0 && max < i) {
        max = i;
      }
    }
    return max;
  }

  private int minValueUnderZero(final int[] arrays) {
    int min = Integer.MAX_VALUE;
    for (int i : arrays) {
      if (i < 0 && min > i) {
        min = i;
      }
    }
    return min;
  }

  private int maxValueOverZero(final int[] arrays) {
    int max = Integer.MIN_VALUE;
    for (int i : arrays) {
      if (i > 0 && max < i) {

        max = i;
      }
    }
    return max;
  }

  private int minValueOverZero(final int[] arrays) {
    int min = Integer.MAX_VALUE;
    for (int i : arrays) {
      if (i > 0 && min > i) {
        min = i;
      }
    }
    return min;
  }

  private void evenNumberArray(final int[] arrays) {
    for (int i : arrays) {
      if (i % 2 == 0) {
        System.out.print(i + " ");
      }
    }
  }

  private void oddNumberArray(final int[] arrays) {
    for (int i : arrays) {
      if (i % 2 !=0) {
        System.out.print(i + " ");
      }
    }
  }

  private int[] addElementByIndex(int element, int index, int[] arrays) {
    int[] newArrays = new int[arrays.length + 1];
    System.out.println(arrays.length);

    newArrays = Arrays.copyOf(arrays, newArrays.length);
    for (int i = newArrays.length - 1; i > index; i--) {
      newArrays[i] = newArrays[i - 1];
    }
    newArrays[index] = element;
    return newArrays;
  }

  private int[] removeElementByIndex(int index, int[] arrays) {
    int[] temp = new int[arrays.length - 1];
    for (int i = arrays.length-1, j = i; i >=0; i--){
      if (i == index) {
        continue;
      }
      j=j-1;
      temp[j] = arrays[i];
    }
    return temp;
  }

  public void optionChoose(final int option, int[] arrays) {

    switch (option) {
    case 1:
      System.out.print("Enter size of arrays: ");
      int n = Integer.valueOf(sc.nextLine());
      if (n <= 0) {
        System.out.println("Please input size of arrays > 0");
      } else {
        setArrays(n, arrays);
        inputArrays(n, this.arrays);
      }
      break;
    case 2:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        System.out.println("\n---PRINT ARRAYS VALUE: ");
        printArrays(arrays);
      }
      break;
    case 3:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        float avgValue = calAvg(arrays);
        System.out.println("Average value of Arrays: " + avgValue);
      }
      break;
    case 4:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        int maxValue = maxValue(arrays);
        int minValue = minValue(arrays);
        System.out.println("Max Value: " + maxValue);
        System.out.println("Min Value: " + minValue);
      }
      break;
    case 5:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        int maxValueUnderZero = maxValueUnderZero(arrays);
        int minValueUnderZero = minValueUnderZero(arrays);

        if (maxValueUnderZero == Integer.MIN_VALUE && minValueUnderZero == Integer.MAX_VALUE) {
          System.out.print("Array  doesn't have any value under zero !");
        } else {
          System.out.println("Max Value under Zero: " + maxValueUnderZero);
          System.out.println("Min Value under Zero: " + minValueUnderZero);
        }
      }
      break;
    case 6:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        int maxValueOverZero = maxValueOverZero(arrays);
        int minValueOverZero = minValueOverZero(arrays);
        if (maxValueOverZero == Integer.MIN_VALUE && minValueOverZero == Integer.MAX_VALUE) {
          System.out.print("Array  doesn't have any value over zero !");
        } else {
          System.out.println("Max Value over Zero: " + maxValueOverZero);
          System.out.println("Min Value over Zero: " + minValueOverZero);
        }
      }
      break;
    case 7:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        System.out.println("Even Number of Arrays: ");
        evenNumberArray(this.arrays);
        System.out.println("\nOdd Number of Arrays: ");
        oddNumberArray(this.arrays);
      }
      break;
    case 8:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        int insertIndex = 0, element = 0;
        System.out.println("Enter index want insert value: ");
        insertIndex = Integer.valueOf(sc.nextLine());
        if (insertIndex > arrays.length) {
          System.out.println("Index doesn't greater size of Arrays, Try again !");
        } else {
          System.out.println("Enter value need for insert: ");
          element = Integer.valueOf(sc.nextLine());
          int[] temp = addElementByIndex(element, insertIndex, arrays);
          System.out.println("Arrays after insert at index "+element);
          System.out.println(Arrays.toString(temp));
          this.setArrays(temp.length, this.getArrays());
          this.arrays = Arrays.copyOf(temp, temp.length);
        }
      }
      break;
    case 9:
      arrays = this.getArrays();
      if (arrays == null || arrays.length == 0) {
        System.out.println("Arrays is empty, please enter value !");
      } else {
        int delIndex = 0;
        System.out.println("Enter index want delete value: ");
        delIndex = Integer.valueOf(sc.nextLine());
        if (delIndex >= arrays.length) {
          System.out.println("Index out of array size,chose other index !");
        } else {
          int[] temp = removeElementByIndex(delIndex, arrays);
          System.out.println("Arrays after delete element at index "+delIndex);
          System.out.println(Arrays.toString(temp));
          this.setArrays(temp.length, this.getArrays());
          this.arrays = Arrays.copyOf(temp, temp.length);
        }
      }
      break;
    }
  }

}
