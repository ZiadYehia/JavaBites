import java.util.Scanner;

public class Main {
    static void ascendingOrder(int copyNum) {
        System.out.println("Lets Count...");
        for (int i = 0; i <= copyNum; i++) {
            if(i == copyNum){
                System.out.println(i);
            }
            else{
                System.out.print(i+" ,");
            }
        }
        System.out.println("------------------------------");
    }

    static void descendingOrder(int copyNum) {
        System.out.println("Lets Count...");
        for (int i = copyNum; i >= 0; i--) {
            if(i == 0){
                System.out.println(i);
            }
            else{
                System.out.print(i+" ,");
            }
        }
        System.out.println("------------------------------");
    }

    static void menu() {
        System.out.println("Welcome to our practice for Loops :D");
        System.out.println("1- Ascending Order");
        System.out.println("2- Descending Order");
        System.out.println("3- Exit");
        System.out.print(": ");
    }

    static boolean optionsPrg(int copyOption) {
        int num;
        boolean status = false;
        Scanner input = new Scanner(System.in);
        switch (copyOption) {
            case 1:
                System.out.print("What Number do you want to count to in Ascending Order ?\n: ");
                num = input.nextInt();
                ascendingOrder(num);
                break;
            case 2:
                System.out.print("What Number do you want to count to in Descending Order ?\n: ");
                num = input.nextInt();
                descendingOrder(num);
                break;
            case 3:
                System.out.println("Exiting....");
                System.out.println("Goodbye ,See You soon :D");
                status = true;
                break;
            default:
                System.out.println("Invalid Entry ,please choose options from 1~3");
        }
        return status;
    }

    static void startPrg() {
        Scanner input = new Scanner(System.in);
        int option;
        boolean status = false;
        while (!status) {
            menu();
            option = input.nextInt();
            status = optionsPrg(option);
        }
    }

    public static void main(String[] args) {
        startPrg();
    }
}