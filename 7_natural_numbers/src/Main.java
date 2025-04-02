import java.util.Scanner;

public class Main {
    static void menu1() {
        System.out.println("Hello user :D");
        System.out.println("Please Enter Array of 10 Elements");
        System.out.println("---------------------------------------");
    }

    static void menu2() {
        System.out.println("---------------------------------------");
        System.out.println("1- view Array");
        System.out.println("2- view Natural Array");
        System.out.println("3- Exit Program");
        System.out.print(": ");
    }

    static int viewArr(double[] copyArr) {
        int sum = 0;
        System.out.println("(Array)\n---------------------------------------");
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.print(copyArr[i]);
            } else {
                System.out.print(copyArr[i] + " ,");
            }
            sum += (int) copyArr[i];
        }
        return sum;
    }

    static int naturalArr(double[] copyArr) {
        int sum = 0;
        System.out.println("(Natural Array)\n---------------------------------------");
        for (int i = 0; i < 10; i++) {
            if (copyArr[i] % 1 != 0) {
                continue;
            } else {
                if (i == 9) {
                    System.out.print(copyArr[i]);
                } else {
                    System.out.print(copyArr[i] + " ,");
                }
                sum += (int) copyArr[i];
            }
        }
        return sum;
    }

    static boolean optionPrg(double[] copyArr, int copyOption) {
        int sum = 0;
        boolean status = false;
        switch (copyOption) {
            case 1:
                System.out.println("Viewing Array...");
                sum = viewArr(copyArr);
                System.out.println("\nSum = " + sum);
                break;
            case 2:
                System.out.println("Viewing Natural Array...");
                sum = naturalArr(copyArr);
                System.out.println("\nSum = " + sum);
                break;
            case 3:
                System.out.println("Exiting ...");
                System.out.println("Goodbye ,See you soon :D");
                status = true;
                break;
        }
        return status;
    }

    static void startPrg() {
        Scanner input = new Scanner(System.in);
        double[] arr;
        int option;
        boolean status = false;
        arr = new double[10];
        menu1();
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter [" + (i + 1) + "] :");
            arr[i] = input.nextDouble();
        }
        while (!status) {
            menu2();
            option = input.nextInt();
            status = optionPrg(arr, option);
        }

    }

    public static void main(String[] args) {
        startPrg();
    }
}
