import java.util.Scanner;

public class Main {

    static void menu() {
        System.out.println("Hello user !!");
        System.out.println("1- Input Array");
        System.out.println("2- View Array");
        System.out.println("3- Search in Array");
        System.out.println("4- Exit");
        System.out.print(":");
    }

    static void sortMenu() {
        System.out.println("Choose Sorting Method:");
        System.out.println("1- Bubble Sort");
        System.out.println("2- Quick Sort");
        System.out.print(":");
    }

    static void searchMenu() {
        System.out.println("Choose Searching Method:");
        System.out.println("1- Linear Search");
        System.out.println("2- Binary Search");
        System.out.print(":");
    }

    static int linearSearch(int[] arr, int target) {  // line 27 -> added
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    static void quick_Sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quick_Sort(arr, low, pi - 1);
            quick_Sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static int[] bubble_Sort(int[] copyArr) {
        for (int i = 0; i < copyArr.length - 1; i++) {
            for (int j = 0; j < copyArr.length - i - 1; j++) {
                if (copyArr[j] > copyArr[j + 1]) {
                    int temp = copyArr[j];
                    copyArr[j] = copyArr[j + 1];
                    copyArr[j + 1] = temp;
                }
            }
        }
        return copyArr;
    }

    static void viewArr(int[] copyArr) {
        for (int i = 0; i < copyArr.length; i++) {
            System.out.println("Element [" + (i + 1) + "] : " + copyArr[i]);
        }
    }

    static int arrSize() {
        int arrSize;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Array Size");
        System.out.print(":");
        arrSize = input.nextInt();
        return arrSize;
    }

    static int[] inputArr(int copyArrSize) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[copyArrSize];
        for (int i = 0; i < copyArrSize; i++) {
            System.out.print("Enter Element [" + (i + 1) + "] :");
            arr[i] = input.nextInt();
            System.out.print("\n");
        }
        return arr;
    }

    static void appStart() {
        Scanner input = new Scanner(System.in);
        int[] arr = null;
        int size = 0;
        int choice = 0;

        while (choice != 4) {
            menu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    size = arrSize();
                    arr = inputArr(size);
                    break;
                case 2:
                    if (arr == null) {
                        System.out.println("Array is empty, please input array first.");
                    } else {
                        viewArr(arr);
                    }
                    break;
                case 3:
                    if (arr == null) {
                        System.out.println("Array is empty, please input array first.");
                    } else {
                        System.out.print("Enter the element to search: ");
                        int target = input.nextInt();

                        sortMenu();  // line 108 -> added
                        int sortChoice = input.nextInt();
                        int[] sortedArr = arr.clone();

                        if (sortChoice == 1) {
                            bubble_Sort(sortedArr);
                        } else if (sortChoice == 2) {
                            quick_Sort(sortedArr, 0, sortedArr.length - 1);
                        } else {
                            System.out.println("Invalid choice, using Bubble Sort by default.");
                            bubble_Sort(sortedArr);
                        }

                        searchMenu();  // line 123 -> added
                        int searchChoice = input.nextInt();

                        int index;
                        if (searchChoice == 1) {
                            index = linearSearch(sortedArr, target);
                        } else if (searchChoice == 2) {
                            index = binarySearch(sortedArr, target);
                        } else {
                            System.out.println("Invalid choice, using Linear Search by default.");
                            index = linearSearch(sortedArr, target);
                        }

                        if (index != -1) {
                            System.out.println("Element found at position (sorted array index): " + (index + 1));
                        } else {
                            System.out.println("Element not found.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice, Try Again.");
            }
        }
    }

    public static void main(String[] args) {
        appStart();
    }
}
