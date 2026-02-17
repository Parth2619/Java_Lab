import java.util.Scanner;

public class calculator {
    public int num1, num2, op;
    public int flag = 0;

    public int addNums(int n1, int n2) {
        return n1 + n2;
    }

    public int SubNums(int n1, int n2) {
        return n1 - n2;
    }

    public int MulNums(int n1, int n2) {
        return n1 * n2;
    }

    public float DivNums(int n1, int n2) {
        return n1 / n2;
    }

    public int CalMod(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculator calc = new calculator();

        do {
            System.out.println("\nEnter First Number");
            calc.num1 = scanner.nextInt();
            System.out.println("Enter Second Number");
            calc.num2 = scanner.nextInt();

            System.out.println("Enter Operation");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            calc.op = scanner.nextInt();

            switch (calc.op) {
                case 1:
                    int sum = calc.addNums(calc.num1, calc.num2);
                    System.out.println("Addition = " + sum);
                    break;
                case 2:
                    int diff = calc.SubNums(calc.num1, calc.num2);
                    System.out.println("Subtraction = " + diff);
                    break;
                case 3:
                    int prod = calc.MulNums(calc.num1, calc.num2);
                    System.out.println("Multiplication = " + prod);
                    break;
                case 4:
                    float div = calc.DivNums(calc.num1, calc.num2);
                    System.out.println("Division = " + div);
                    break;
                case 5:
                    int mod = calc.CalMod(calc.num1, calc.num2);
                    System.out.println("Modulus = " + mod);
                    break;
                default:
                    System.out.println("Invalid Operation - Exiting...");
                    calc.flag = 1;
                    break;
            }

            if (calc.flag == 0) {
                System.out.print("\nDo you want to continue? (Y/N): ");
                char choice = scanner.next().charAt(0);
                if (choice == 'N' || choice == 'n') {
                    System.out.println("Bye");
                    calc.flag = 1;
                }
            }
        } while (calc.flag == 0);

        scanner.close();
    }
}
