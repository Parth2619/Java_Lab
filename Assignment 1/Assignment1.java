import java.util.Scanner;

public class Assignment1 {
    public int num1, num2;

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
        Assignment1 op = new Assignment1();

        System.out.println("Enter First Number");
        op.num1 = scanner.nextInt();
        System.out.println("Enter Second Number");
        op.num2 = scanner.nextInt();

        int sum = op.addNums(op.num1, op.num2);
        int diff = op.SubNums(op.num1, op.num2);
        int prod = op.MulNums(op.num1, op.num2);
        float div = op.DivNums(op.num1, op.num2);
        int mod = op.CalMod(op.num1, op.num2);

        System.out.println("Addition = " + sum);
        System.out.println("Subtraction = " + diff);
        System.out.println("Multiplication = " + prod);
        System.out.println("Division = " + div);
        System.out.println("Modulus = " + mod);

        System.out.println("Sum of the numbers: " + op.addNums(op.num1, op.num2));
        System.out.println("Difference of the numbers: " + op.SubNums(op.num1, op.num2));
        System.out.println("Product of the numbers: " + op.MulNums(op.num1, op.num2));
        System.out.println("Division of the numbers: " + op.DivNums(op.num1, op.num2));
        System.out.println("Modulus of the numbers: " + op.CalMod(op.num1, op.num2));

        scanner.close();
    }

}